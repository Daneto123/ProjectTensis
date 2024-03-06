package com.IotSensor.IotSensorArt;

import com.IotSensor.IotSensorArt.TempSensor.TempResponseData;
import com.IotSensor.IotSensorArt.TempSensor.TempSensorService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class TempSensorServiceTests {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private TempSensorService tempSensorService;
    @Test
    public void fetchDataFromExternalAPI() {
        String externalAPIUrl = "https://localhost:8080/api/data";
        String mockResponseData = "Mocked response data";

        //tempSensorService.setExternalAPIUrl(externalAPIUrl);

        //when(restTemplate.getForObject(externalAPIUrl, TempResponseData.class)).thenReturn(new TempResponseData(mockResponseData));

        //String result = tempSensorService.fetchDataFromExternalAPI();

        //assertEquals(mockResponseData, result);
        //assertEquals(mockResponseData, tempSensorService.getResponseData());

    }

    @Test
    public void fetchDataFromExternalAPIwithExeptions() {
        String externalAPIUrl = "https://example.com/api/data";

        //tempSensorService.setExternalAPIUrl(externalAPIUrl);

        //when(restTemplate.getForObject(externalAPIUrl, TempResponseData.class)).thenReturn(new TempResponseData(mockResponseData));

        //String result = tempSensorService.fetchDataFromExternalAPI();

        /*assertThrows(RuntimeException.class, () -> {
            tempSensorService.fetchDataFromExternalAPI();
        });*/

        //assertEquals("", tempSensorService.getResponseData());

    }

}
