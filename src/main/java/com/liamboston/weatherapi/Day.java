package com.liamboston.weatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Day {
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("tempmin")
    private double tempmin;
    @JsonProperty("tempmax")
    private double tempmax;
    @JsonProperty("preciptype")
    private List<String> preciptype;
    @JsonProperty("precipprob")
    private double precipprob;
    @JsonProperty("description")
    private String description;

    // Getters and Setters
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTempmin() {
        return tempmin;
    }

    public void setTempmin(double tempmin) {
        this.tempmin = tempmin;
    }

    public double getTempmax() {
        return tempmax;
    }

    public void setTempmax(double tempmax) {
        this.tempmax = tempmax;
    }

    public double getPrecipprob() {
        return precipprob;
    }

    public void setPrecipprob(double precipprob) {
        this.precipprob = precipprob;
    }

    public List<String> getPreciptype() {
        return preciptype;
    }

    public void setPreciptype(List<String> preciptype) {
        this.preciptype = preciptype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "<b>" + datetime + "</b><br>" +
                "<b>Forecast: </b>" + description + "<br>" +
                "<b>Low: </b>" + tempmin + "<b>° | High: </b>" + tempmax + "<b>°</b><br>" +
                "<b>Precipitation: </b>" + (preciptype != null && !preciptype.isEmpty() ? String.join(", ", preciptype) : "None") +
                "<b> | Probability: </b>" + precipprob + "%.<br><br>";
    }
}
