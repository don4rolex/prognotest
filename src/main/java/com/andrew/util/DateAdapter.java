package com.andrew.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrew
 */
public class DateAdapter extends XmlAdapter<String, Date> {

  private static final String format = "yyyy-MM-dd HH:mm:ss";

  @Override
  public String marshal(Date input) {
    try {
      return input == null ? null : new SimpleDateFormat(format).format(input);
    } catch (Exception ex) {
      return input.toString();
    }
  }

  @Override
  public Date unmarshal(String input) {
    try {
      return new SimpleDateFormat(format).parse(input); // Because SDF is not threadsafe.
    } catch (ParseException ex) {
      ex.printStackTrace();
    }

    return null;
  }
}
