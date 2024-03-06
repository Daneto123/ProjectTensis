package com.IotSensor.IotSensorArt.TempSensor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class TempSensorService {

    private String externalAPIUrl;

    private String responseData;

    public TempSensorService() {
        setExternalAPIUrl("http://localhost:8080/api/postTemp");
    }

    public String getExternalAPIUrl() {
        return externalAPIUrl;
    }

    public void setExternalAPIUrl(String externalAPIUrl) {
        this.externalAPIUrl = externalAPIUrl;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    @GetMapping("api/postTemp")
    public String fetchDataFromExternalAPI() {
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request to the external API
        setResponseData(String.valueOf(restTemplate.getForObject(getExternalAPIUrl(), TempResponseData.class)));

        return getResponseData();
    }
}
