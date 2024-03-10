package com.IotSensor.IotSensorArt.InfluxDB;

public class InfluxDBConfig {

    public InfluxDBConfig() {
    }

    public InfluxDBService connetToInfluxDB() {
        String influxDbUrl = "http://host.docker.internal:8086/";
        String username = "sebis";
        String password = "test12345";

        InfluxDBService dbConfig = new InfluxDBService(influxDbUrl, username, password, "temperature-sensor");

        //     InfluxDBFactory.connect(influxDBUrl, token.toCharArray());
        return dbConfig;
    }
}
