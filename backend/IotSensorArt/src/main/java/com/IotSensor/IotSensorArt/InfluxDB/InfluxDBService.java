package com.IotSensor.IotSensorArt.InfluxDB;

import com.IotSensor.IotSensorArt.User.UserData;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InfluxDBService {

    private InfluxDB influxDB;
    private String influxDbUrl;
    private String influxDbUsername;
    private String influxDbPassword;
    private String influxDbDatabase;

    public InfluxDBService() {

    }

    public InfluxDBService(String influxDbUrl, String influxDbUsername, String influxDbPassword, String influxDbDatabase) {
        this.influxDB = connectToInfluxDB();
        influxDbUrl = "http://host.docker.internal:8086";
        setInfluxDbUsername(influxDbUsername);
        setInfluxDbPassword(influxDbPassword);
        setInfluxDbDatabase(influxDbDatabase);
    }

    public String getInfluxDbUrl() {
        return influxDbUrl;
    }

    public void setInfluxDbUrl(String influxDbUrl) {
        this.influxDbUrl = influxDbUrl;
    }

    public String getInfluxDbUsername() {
        return influxDbUsername;
    }

    public void setInfluxDbUsername(String influxDbUsername) {
        this.influxDbUsername = influxDbUsername;
    }

    public String getInfluxDbPassword() {
        return influxDbPassword;
    }

    public void setInfluxDbPassword(String influxDbPassword) {
        this.influxDbPassword = influxDbPassword;
    }

    public String getInfluxDbDatabase() {
        return influxDbDatabase;
    }

    public void setInfluxDbDatabase(String influxDbDatabase) {
        this.influxDbDatabase = influxDbDatabase;
    }

    public InfluxDB connectToInfluxDB() {
        return InfluxDBFactory.connect(getInfluxDbUrl(), getInfluxDbUsername(), getInfluxDbPassword());
    }

    public void writeTemperatureData(String typeroom, String namepi, double temp) {
        BatchPoints batchPoints = BatchPoints
                .database(getInfluxDbDatabase())
                .retentionPolicy("defaultPolicy")
                .build();

        Point point = Point.measurement("temperature")
                .addField("typeroom", typeroom)
                .addField("namepi", namepi)
                .addField("temp", temp)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .build();

        batchPoints.point(point);

        influxDB.write(batchPoints);
    }

    public void createDatabaseForUser(String username) {
        // Use InfluxDB Java client to create a new database for the user
        InfluxDB influxDB = connectToInfluxDB();
        setInfluxDbDatabase("user_" + username);
        influxDB.createDatabase(getInfluxDbDatabase());
        influxDB.close();
    }

    public UserData findByUsername(String username) {

        String query = "SELECT * FROM user WHERE username = '" + username + "'";
        QueryResult queryResult = influxDB.query(new Query(query, influxDbDatabase));
        List<List<Object>> values = new ArrayList<>();

        for (QueryResult.Result result : queryResult.getResults()) {
            for (QueryResult.Series series : result.getSeries()) {
                // Iterate over the series and access data
                System.out.println("Columns: " + series.getColumns());
                System.out.println("Values: " + series.getValues());
                values = series.getValues();
                //userData.add(new UserData(series.getValues().get(1)))

            }
        }

        for (List<Object> row : values) {
            for (Object value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        return (UserData) values.get(0);
    }

    public void deleteByUsername(String username) {

        String deleteQuery = "DELETE FROM user WHERE username = '" + username + "'";
        influxDB.query(new Query(deleteQuery, influxDbDatabase));

    }

    public boolean save(UserData userData) {
        BatchPoints batchPoints = BatchPoints
                .database("user")
                .retentionPolicy("defaultPolicy")
                .build();

        Point point = Point.measurement("temperature")
                .addField("username", userData.getUsername())
                .addField("password", userData.getPassword())
                .addField("email", userData.getEmail())
                .addField("serviceName", userData.getServiceName()[0])
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .build();

        batchPoints.point(point);

        influxDB.write(batchPoints);

        return true;
    }
}

