package com.texttosql.textToSql.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIIntegrationService {

//    private final RestTemplate restTemplate;

    public AIIntegrationService() {

    }

    public String callAiModel(String textQuery) {
//        String apiUrl = "https://dummy.ai.api.com/v1/queries";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer YOUR_API_KEY");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        String body = String.format("{\"query\": \"%s\", \"max_tokens\": 150}", textQuery);
//        HttpEntity<String> entity = new HttpEntity<>(body, headers);
//
//        try {
//            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
//            return response.getBody();
//        } catch (Exception e) {
//            // Log or handle the exception as needed
//            System.err.println("Error calling AI model: " + e.getMessage());
//            return null; // Or return a default response/error message
//        }
        System.out.println("textQuery was:"+textQuery);
        return "SELECT * FROM students";
    }
}
