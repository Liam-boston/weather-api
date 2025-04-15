package com.liamboston.weatherapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String API_KEY = "C6RYG2CVQMRPTFH5VMRSA5FXL";
    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    public String getWeather(String country) {
        String url = BASE_URL + country + "/?key=" + API_KEY;

        // Using RestTemplate to make HTTP Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Return response body as a String (can be parsed into a proper object later)
        return response.getBody();
    }
}
