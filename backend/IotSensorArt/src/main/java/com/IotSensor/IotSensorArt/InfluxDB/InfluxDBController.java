package com.IotSensor.IotSensorArt.InfluxDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxDBController {

    @PostMapping("/write-temperature")
    public void writeTemperatureData(String typeroom , String namepi, double temp) {

        InfluxDBService dbService = new InfluxDBService();

        dbService.writeTemperatureData(typeroom, namepi, temp);

    }
}

