package com.IotSensor.IotSensorArt.TempSensor;

import org.springframework.web.client.RestTemplate;

public class TempSensorService {

    private final String externalAPIUrl = "https://localhost:3515/api/post";

    public String fetchDataFromExternalAPI() {
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request to the external API
        String responseData = String.valueOf(restTemplate.getForObject(externalAPIUrl, ResponseData.class));

        return responseData;
    }
}
