package com.IotSensor.IotSensorArt.User;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBConfig;
import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserData loginData) {

        if (validateUser(loginData)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    public boolean validateUser(UserData loginData) {
        InfluxDBConfig db = new InfluxDBConfig();
        InfluxDBService influxDB = db.connetToInfluxDB();

        influxDB.connectToInfluxDB();

        UserData user = (UserData) influxDB.findByUsername(loginData.getUsername());
        return user != null && user.getPassword().equals(loginData.getPassword());
    }

}
