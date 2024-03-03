package com.IotSensor.IotSensorArt.InfluxDB;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDBConfig {

    @Bean
    public InfluxDB influxDB() {
        String influxDbUrl = "http://host.docker.internal:8086/";
        String username = "sebis";
        String password = "test12345";

        return InfluxDBFactory.connect(influxDbUrl, username, password);
    }
}
