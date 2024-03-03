package com.IotSensor.IotSensorArt.InfluxDB;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class InfluxDBService {

    private final InfluxDB influxDB;
    @Value("${influxdb.url}")
    private String influxDbUrl;

    @Value("${influxdb.username}")
    private String influxDbUsername;

    @Value("${influxdb.password}")
    private String influxDbPassword;

    @Value("${influxdb.database}")
    private String influxDbDatabase;

    public InfluxDBService() {
    }

    public InfluxDBService(InfluxDB influxDB, String influxDbUrl, String influxDbUsername, String influxDbPassword, String influxDbDatabase) {
        this.influxDB = influxDB;
        this.influxDbUrl = influxDbUrl;
        this.influxDbUsername = influxDbUsername;
        this.influxDbPassword = influxDbPassword;
        this.influxDbDatabase = influxDbDatabase;
    }

    public InfluxDBService(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

    public InfluxDB connectToInfluxDB() {
        return InfluxDBFactory.connect(influxDbUrl, influxDbUsername, influxDbPassword);
    }

    public void writeTemperatureData(String typeroom, String namepi, double temp) {
        Point point = Point.measurement("temperature")
                .tag("typeroom", typeroom)
                .tag("namepi", namepi)
                .addField("temp", temp)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .build();

        influxDB.write("tempDB", "autogen", point); // Assuming "tempDB" is your InfluxDB bucket
    }

    public void createDatabaseForUser(String username) {
        // Use InfluxDB Java client to create a new database for the user
        InfluxDB influxDB = InfluxDBFactory.connect(influxDbUrl, "admin", "admin");
        String databaseName = "user_" + username;
        influxDB.createDatabase(databaseName);
        influxDB.close();
    }
}

