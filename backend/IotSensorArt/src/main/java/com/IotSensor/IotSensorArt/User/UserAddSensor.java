package com.IotSensor.IotSensorArt.User;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBConfig;
import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import com.IotSensor.IotSensorArt.TempSensor.TempResponseData;
import com.IotSensor.IotSensorArt.TempSensor.TempSensorService;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

public class UserAddSensor {

    public boolean addNewSensor(TempResponseData sensorData, String username) {

        InfluxDBConfig db = new InfluxDBConfig();
        InfluxDBService influxDB = db.connetToInfluxDB();
        influxDB.setInfluxDbDatabase("user" + username);

        influxDB.writeTemperatureData(sensorData.getroomtype(), sensorData.getNamepi(), sensorData.getTemp());

        return true;
    }

}
