package com.eestecapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Spiros I. Oikonomakis on 08/12/15.
 */
public class Utils {

  // Reads an InputStream and converts it to a String.
  public static String readIt(InputStream stream, int len) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    StringBuffer res = new StringBuffer();
    String line;
    while ((line = reader.readLine()) != null) {
      res.append(line);
    }
    reader.close();
    return res.toString();
  }
}
