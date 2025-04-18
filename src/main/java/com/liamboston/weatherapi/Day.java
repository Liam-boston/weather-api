package com.liamboston.weatherapi;

public class Day {
    private String dateTime;
    private double tempmax;
    private double tempmin;
    private double feelslike;
    private double humidity;
    private double precip;
    private double precipProp;
    private String precipType;

    // Getters and setters
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getTempmax() {
        return tempmax;
    }

    public void setTempmax(double tempmax) {
        this.tempmax = tempmax;
    }

    public double getTempmin() {
        return tempmin;
    }

    public void setTempmin(double tempmin) {
        this.tempmin = tempmin;
    }

    public double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(double feelslike) {
        this.feelslike = feelslike;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getPrecipProp() {
        return precipProp;
    }

    public void setPrecipProp(double precipProp) {
        this.precipProp = precipProp;
    }

    // Helper method to format the message like: "With a high of 78°F and low of 48°F"
    public String getTempMessage() {
        return String.format("With a high of %.1f°F and low of %.1f°F", tempmax, tempmin);
    }
}
