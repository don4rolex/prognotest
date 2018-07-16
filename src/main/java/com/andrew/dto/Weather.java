package com.andrew.dto;


import com.andrew.util.DateAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrew
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

  private static final long serialVersionUID = 1L;

  public Weather() {
  }

  private WeatherObservation weatherObservation;

  public WeatherObservation getWeatherObservation() {
    return weatherObservation;
  }

  public void setWeatherObservation(WeatherObservation weatherObservation) {
    this.weatherObservation = weatherObservation;
  }

  @Override
  public String toString() {
    return "Weather{" +
        "weatherObservation=" + weatherObservation +
        '}';
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class WeatherObservation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String weatherCondition;
    private String clouds;
    private String observation;
    private String windDirection;
    private String ICAO;
    private String elevation;
    private String countryCode;
    private String cloudsCode;
    private Double lng;
    private String dewPoint;
    private String temperature;
    private String windSpeed;
    private String humidity;
    private Date datetime;
    private String stationName;
    private Double lat;
    private String hectoPascAltimeter;
    private String weatherConditionCode;

    public WeatherObservation() {
    }

    public String getWeatherCondition() {
      return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
      this.weatherCondition = weatherCondition;
    }

    public String getClouds() {
      return clouds;
    }

    public void setClouds(String clouds) {
      this.clouds = clouds;
    }

    public String getObservation() {
      return observation;
    }

    public void setObservation(String observation) {
      this.observation = observation;
    }

    public String getWindDirection() {
      return windDirection;
    }

    public void setWindDirection(String windDirection) {
      this.windDirection = windDirection;
    }

    @XmlElement(name = "ICAO")
    public String getICAO() {
      return ICAO;
    }

    public void setICAO(String ICAO) {
      this.ICAO = ICAO;
    }

    public String getElevation() {
      return elevation;
    }

    public void setElevation(String elevation) {
      this.elevation = elevation;
    }

    public String getCountryCode() {
      return countryCode;
    }

    public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
    }

    public String getCloudsCode() {
      return cloudsCode;
    }

    public void setCloudsCode(String cloudsCode) {
      this.cloudsCode = cloudsCode;
    }

    public Double getLng() {
      return lng;
    }

    public void setLng(Double lng) {
      this.lng = lng;
    }

    public String getDewPoint() {
      return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
      this.dewPoint = dewPoint;
    }

    public String getTemperature() {
      return temperature;
    }

    public void setTemperature(String temperature) {
      this.temperature = temperature;
    }

    public String getWindSpeed() {
      return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
      this.windSpeed = windSpeed;
    }

    public String getHumidity() {
      return humidity;
    }

    public void setHumidity(String humidity) {
      this.humidity = humidity;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getDatetime() {
      return datetime;
    }

    public void setDatetime(Date datetime) {
      this.datetime = datetime;
    }

    public String getStationName() {
      return stationName;
    }

    public void setStationName(String stationName) {
      this.stationName = stationName;
    }

    public Double getLat() {
      return lat;
    }

    public void setLat(Double lat) {
      this.lat = lat;
    }

    public String getHectoPascAltimeter() {
      return hectoPascAltimeter;
    }

    public void setHectoPascAltimeter(String hectoPascAltimeter) {
      this.hectoPascAltimeter = hectoPascAltimeter;
    }

    public String getWeatherConditionCode() {
      return weatherConditionCode;
    }

    public void setWeatherConditionCode(String weatherConditionCode) {
      this.weatherConditionCode = weatherConditionCode;
    }

    @Override
    public String toString() {
      return "WeatherObservation{" +
          "weatherCondition='" + weatherCondition + '\'' +
          ", clouds='" + clouds + '\'' +
          ", observation='" + observation + '\'' +
          ", windDirection='" + windDirection + '\'' +
          ", ICAO='" + ICAO + '\'' +
          ", elevation='" + elevation + '\'' +
          ", countryCode='" + countryCode + '\'' +
          ", cloudsCode='" + cloudsCode + '\'' +
          ", lng='" + lng + '\'' +
          ", dewPoint='" + dewPoint + '\'' +
          ", temperature='" + temperature + '\'' +
          ", windSpeed='" + windSpeed + '\'' +
          ", humidity='" + humidity + '\'' +
          ", datetime='" + datetime + '\'' +
          ", stationName='" + stationName + '\'' +
          ", lat='" + lat + '\'' +
          ", hectoPascAltimeter='" + hectoPascAltimeter + '\'' +
          '}';
    }
  }
}
