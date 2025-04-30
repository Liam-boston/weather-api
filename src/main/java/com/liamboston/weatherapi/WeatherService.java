package com.liamboston.weatherapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Cacheable(value="weather", key="#country", cacheManager = "cacheManager")
    public String getWeatherByLocation(String location) {
        // Check redis for cached weather results
        String cachedWeather = redisTemplate.opsForValue().get(location);

        if (cachedWeather != null) {
            System.out.println("Cache hit for " + location);
            return cachedWeather;
        }

        String url = BASE_URL + location + "/?key=" + apiKey;

        // Using RestTemplate to make HTTP Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Parse the JSON response to a Weather object using Jackson
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Weather weather = mapper.readValue(response.getBody(), Weather.class);

            // Limit forecast to 7-days
            if (weather.getDays() != null && weather.getDays().size() > 7) {
                weather.setDays(weather.getDays().subList(0, 7)); // take only the first 7 days
            }

            // Cache the result
            String result = weather.toString();
            redisTemplate.opsForValue().set(location, result, Duration.ofHours(12));

            System.out.println("Weather data fetched and cached for " + location);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "ERROR FETCHING WEATHER DATA";
        }
    }
}
