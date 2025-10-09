package com.example.smartcommutebackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/external")
@CrossOrigin(origins = "http://localhost:5173")
public class ExternalAPIController {

    private final RestTemplate restTemplate = new RestTemplate();

    // Existing external APIs
    @GetMapping("/metro")
    public ResponseEntity<?> getExternalMetroData() {
        String externalUrl = "https://api.publicapis.org/entries"; // placeholder/test
        try {
            String response = restTemplate.getForObject(externalUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.err.println("❌ Error calling external API: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to fetch external data: " + e.getMessage());
        }
    }

    @GetMapping("/bus")
    public ResponseEntity<?> getExternalBusData() {
        String externalUrl = "https://api.publicapis.org/entries"; // placeholder/test
        try {
            String response = restTemplate.getForObject(externalUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.err.println("❌ Error calling external API: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to fetch external data: " + e.getMessage());
        }
    }

    // ✅ New endpoint: fetch combined real-time routes
    @GetMapping("/routes")
    public ResponseEntity<?> getRoutes(@RequestParam String source, @RequestParam String destination) {
        try {
            // Replace with actual external APIs for Metro, Bus, and Train
            String metroData = restTemplate.getForObject(
                    "https://api.chennaimetrorail.org/v1/routes?source=" + source + "&destination=" + destination,
                    String.class);
            String busData = restTemplate.getForObject(
                    "https://routemaps.info/route/chennai-city-bus/?source=" + source + "&destination=" + destination,
                    String.class);
            String trainData = restTemplate.getForObject(
                    "https://indianrailapi.com/api/v1/routes?source=" + source + "&destination=" + destination,
                    String.class);

            // Combine results into one JSON object
            String combined = "{ \"metro\": " + metroData +
                    ", \"bus\": " + busData +
                    ", \"train\": " + trainData + " }";

            return ResponseEntity.ok(combined);

        } catch (RestClientException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to fetch routes: " + e.getMessage());
        }
    }
}
