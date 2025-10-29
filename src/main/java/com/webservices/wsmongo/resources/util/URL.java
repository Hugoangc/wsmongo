package com.webservices.wsmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public class URL {

  public static String decodeParam(String text) {
    try {
      return URLDecoder.decode(text, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return "";
    }
  }

  public static Instant convertToInstant(String textDate, Instant defaultValue) {
    try {
      LocalDate localDate = LocalDate.parse(textDate);
      return localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
    } catch (DateTimeParseException e) {
      return defaultValue;
    }
  }
}
