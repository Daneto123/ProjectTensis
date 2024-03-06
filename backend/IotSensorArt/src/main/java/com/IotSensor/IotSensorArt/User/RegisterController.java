package com.IotSensor.IotSensorArt.User;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBConfig;
import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RegisterController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserData formData) {

        //influxDBService.createDatabaseForUser("user_" + formData.getUsername());
        InfluxDBConfig db = new InfluxDBConfig();
        InfluxDBService influxDB = db.connetToInfluxDB();

        influxDB.connectToInfluxDB();
        influxDB.createDatabaseForUser("user_" + formData.getUsername());


        UserData user = new UserData(formData.getUsername(), formData.getPassword(), formData.getEmail(), formData.getServiceName());
        influxDB.save(user);

        return ResponseEntity.ok("Data received and stored successfully!");
    }
}
