package com.IotSensor.IotSensorArt;

import com.IotSensor.IotSensorArt.InfluxDB.InfluxDBService;
import com.IotSensor.IotSensorArt.User.RegisterController;
import com.IotSensor.IotSensorArt.User.UserData;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class RegisterControllerTests {
    @Mock
    private InfluxDB influxDB;

    @Mock
    private InfluxDBService influxDBService;

    @InjectMocks
    private RegisterController registerController;

    @Test
    public void testRegisterUser() {
        // Arrange
        UserData testData = new UserData("testUser", "testPassword", "test@example.com", new String[]{"service1", "service2"});

        // Act
        ResponseEntity<String> response = registerController.registerUser(testData);

        // Assert
        assertEquals("Data received and stored successfully!", response.getBody());

        // Verify that the createDatabaseForUser method is called with the correct username
        Mockito.verify(influxDBService, Mockito.times(1)).createDatabaseForUser("testUser");
    }

    @Test
    public void testRegisterUserExceptionHandling() {
        // Arrange
        UserData testData = new UserData("testUser", "testPassword", "test@example.com", new String[]{"service1", "service2"});

        // Mock InfluxDBService to throw an exception
        doThrow(new InfluxDBException("Simulated exception")).when(influxDBService).createDatabaseForUser(testData.getUsername());

        // Act and Assert
        assertThrows(InfluxDBException.class, () -> {
            registerController.registerUser(testData);
        });

        // Verify that the createDatabaseForUser method is called with the correct username
        Mockito.verify(influxDBService, Mockito.times(1)).createDatabaseForUser("testUser");
    }
}
