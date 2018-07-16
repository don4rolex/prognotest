package com.andrew.endpoint;

import com.andrew.business.WeatherHandler;
import com.andrew.dto.Weather;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Andrew
 */
@Path("weather")
public class WeatherEndpoint {

  @Inject
  private WeatherHandler handler;

  @GET
  @Produces(APPLICATION_JSON)
  public Weather getWeatherInformation(@QueryParam("latitude") Double latitude,
                                       @QueryParam("longitude") Double longitude) {

    return handler.getWeatherInformation(latitude, longitude);
  }
}
