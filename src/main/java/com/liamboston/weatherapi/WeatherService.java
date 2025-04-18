package com.liamboston.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    public String getWeather(String country) {
        String url = BASE_URL + country + "/?key=" + apiKey;

        // Using RestTemplate to make HTTP Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Return response body as a String (can be parsed into a proper object later)
        return response.getBody();
    }
}
