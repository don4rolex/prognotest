package com.andrew.business;

import com.andrew.dto.Weather;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Andrew
 */
@ApplicationScoped
public class WeatherHandler {

  private final String baseUrl = "http://api.geonames.org/findNearByWeatherJSON";
  private final String username = "prognotest";
  private Client client;

  @PostConstruct
  public void setup() {
    client = new ResteasyClientBuilder().build();
  }

  public Weather getWeatherInformation(Double latitude, Double longitude) {
    return client.target(baseUrl)
        .queryParam("lat", latitude)
        .queryParam("lng", longitude)
        .queryParam("username", username)
        .request()
        .header("Content-Type", APPLICATION_JSON)
        .get(Weather.class);
  }
}
