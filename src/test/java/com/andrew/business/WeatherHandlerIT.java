package com.andrew.business;

import com.andrew.dto.Weather;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew
 */
@RunWith(Arquillian.class)
public class WeatherHandlerIT {

  @Inject
  private WeatherHandler sut;

  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class)
        .addClass(WeatherHandler.class)
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Test
  public void getWeatherInformation_Abuja() {
    final Weather weather = sut.getWeatherInformation(9.0, 7.0);
    assertEquals("ABUJA", weather.getWeatherObservation().getStationName());
    assertEquals("NG", weather.getWeatherObservation().getCountryCode());
    assertEquals("DNAA", weather.getWeatherObservation().getICAO());
  }

  @Test
  public void getWeatherInformation_SanSebastian() {
    final Weather weather = sut.getWeatherInformation(43.0, -2.0);
    assertEquals("San Sebastian / Fuenterrabia", weather.getWeatherObservation().getStationName());
    assertEquals("ES", weather.getWeatherObservation().getCountryCode());
    assertEquals("LESO", weather.getWeatherObservation().getICAO());
  }
}