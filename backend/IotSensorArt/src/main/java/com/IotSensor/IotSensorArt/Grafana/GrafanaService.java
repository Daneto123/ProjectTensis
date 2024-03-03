package com.IotSensor.IotSensorArt.Grafana;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GrafanaService {

    @Value("${grafana.url}")
    private String grafanaUrl;

    public void createOrganizationForUser(String username) {
        // Use Grafana HTTP API to create a new organization for the user
        String organizationName = "org_" + username;

        String requestBody = "{\"name\":\"" + organizationName + "\",\"role\":\"Viewer\"}";

        // Set up the HTTP entity with headers and payload
        HttpEntity<String> entity = new HttpEntity<>(requestBody, "headers");

        // Set up RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Define the URL for creating organizations
        String createOrgUrl = grafanaUrl + "/api/org";

        try {
            // Make the HTTP request to create the organization
            ResponseEntity<String> response = restTemplate.exchange(
                    createOrgUrl,
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // Check the response status and log or handle accordingly
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Organization created successfully for user: " + username);
            } else {
                System.err.println("Failed to create organization for user: " + username);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }
}
