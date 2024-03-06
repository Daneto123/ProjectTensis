package com.IotSensor.IotSensorArt;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotSensorArtApplication {

	public static void main(String[] args) {

		SpringApplication.run(IotSensorArtApplication.class, args);

		// connect to db
		InfluxDBConfig dbconfig = new InfluxDBConfig();
		dbconfig.influxDB();
	}

}
