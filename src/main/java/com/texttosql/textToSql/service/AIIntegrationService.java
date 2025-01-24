package com.texttosql.textToSql.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AIIntegrationService {

//    private final RestTemplate restTemplate;

    public AIIntegrationService() {

    }

    public String callAiModel(String textQuery) {
        String apiUrl = "http://localhost:8000/process_llm";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("text", textQuery);
        HttpHeaders headers = new HttpHeaders();
// Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<Map<String,Object>> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            System.out.println("Response: " + response.getBody());
            return response.getBody();
        } catch (Exception e) {
            // Log or handle the exception as needed
            System.err.println("Error calling AI model: " + e.getMessage());
            return null; // Or return a default response/error message
        }
    }
}
