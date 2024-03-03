package com.IotSensor.IotSensorArt.User;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import com.google.api.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class AuthController extends UserData {
    @Autowired
    private InfluxDB influxDB;
    public AuthController(String username, String password) {
        super(username, password, email, serviceName);
        this.influxDB = new InfluxDBService().connectToInfluxDB();
    }

    public boolean authenticate(String username, String password) {
        // Query InfluxDB to retrieve user credentials
        String query = "SELECT password FROM users WHERE username='" + username + "'";
        QueryResult queryResult = influxDB.query(new Query(query, "yourDatabaseName"));

        if (queryResult.getResults() != null && !queryResult.getResults().isEmpty()) {
            String storedPassword = extractStoredPassword(queryResult);

            return verifyPassword(password, storedPassword);
        }

        return false;
    }

    private boolean verifyPassword(String password, String storedPassword) {
        return BCrypt.checkpw(password, storedPassword);
    }

    private String extractStoredPassword(QueryResult queryResult) {
        // Assuming one series and one result for simplicity
        QueryResult.Result result = queryResult.getResults().get(0);
        QueryResult.Series series = result.getSeries().get(0);

        // Assuming 'password' is the field name in the 'users' measurement
        List<List<Object>> values = series.getValues();
        if (values != null && !values.isEmpty()) {
            return values.get(0).get(series.getColumns().indexOf("password")).toString();
        }

        // No password found (shouldn't reach here for a well-formed query)
        return null;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
