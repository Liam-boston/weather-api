package com.liamboston.weatherapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

//        return response.getBody();
        // Parse the JSON response to a Weather object using Jackson
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Weather weather = mapper.readValue(response.getBody(), Weather.class);
            System.out.println("Weather data fetched: " + weather);
            return weather.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "ERROR FETCHING WEATHER DATA";
        }
    }
}
