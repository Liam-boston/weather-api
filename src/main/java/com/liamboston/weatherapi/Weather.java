package com.liamboston.weatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Weather {
    @JsonProperty("address")
    private String address;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("description")
    private String description;
    @JsonProperty("days")
    private List<Day> days;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weather forecast for <b><u>")
                .append(address)
                .append("</u></b> (")
                .append(timezone)
                .append("): <br>")
                .append(description)
                .append("<br><br>");

        if (days != null && !days.isEmpty()) {
            sb.append("<b><u>7-day forecast:</u></b><br>");
            for (Day day : days) {
                sb.append(day.toString()).append("<br>");
            }
        } else {
            sb.append("No daily forecast available.");
        }

        return sb.toString();
    }

}
