package com.IotSensor.IotSensorArt.InfluxDB;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDBConfig {

    public InfluxDBConfig() {
    }

    @Bean
    public InfluxDBService connetToInfluxDB() {
        String influxDbUrl = "http://host.docker.internal:8086/";
        String username = "sebis";
        String password = "test12345";

        InfluxDBService dbConfig = new InfluxDBService(influxDbUrl, username, password, "temperature-sensor");

        //     InfluxDBFactory.connect(influxDBUrl, token.toCharArray());
        return dbConfig;
    }
}
