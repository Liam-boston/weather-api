package com.liamboston.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/weather/{location}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getWeather(@PathVariable String location) {
        return weatherService.getWeatherByLocation(location);
    }
}
