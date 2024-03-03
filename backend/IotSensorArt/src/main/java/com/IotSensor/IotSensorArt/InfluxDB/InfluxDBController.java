package com.IotSensor.IotSensorArt.InfluxDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/influx")
public class InfluxDBController {

    private final InfluxDBService influxDBService;

    @Autowired
    public InfluxDBController(InfluxDBService influxDBService) {
        this.influxDBService = influxDBService;
    }

    @PostMapping("/write-temperature")
    public void writeTemperatureData() {
        // Example data, replace with your actual data
        String typeroom = "living_room";
        String namepi = "pi_device_1";
        double temp = 22.5;

        influxDBService.writeTemperatureData(typeroom, namepi, temp);
    }
}

