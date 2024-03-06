package com.IotSensor.IotSensorArt;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InfluxDBConfigTests {
    @Mock
    private InfluxDB influxDB;

    @Test
    public void testInfluxDBConnection() {
        assertNotNull(influxDB);

        QueryResult queryResult = influxDB.query(new Query("SHOW DATABASES"));

        List<QueryResult.Result> results = queryResult.getResults();
        assertEquals(1, results.size());

        QueryResult.Series series = results.get(0).getSeries().get(0);
        assertEquals("databases", series.getName());
    }
}

