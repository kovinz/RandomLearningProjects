package com.company;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    try {
      File file = new File("bla.txt");
      byte[] bytes = new byte[]{8, 3, 5};
      InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
      System.out.println(byteArrayInputStream.read());
      InputStream fileInputStream = new FileInputStream(file);
      InputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
      System.out.println(bufferedInputStream.read());
      OutputStream fileOutputStream = new FileOutputStream(file);
      Paths.get("bla.txt");
      int i = fileInputStream.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void add(Map<String, Integer> counts, String key){
    counts.merge(key, 1, (a, b) -> a + b);
    counts.keySet().removeIf(value -> value.equals("wow") || value.equals("hello"));
    Iterator<Map.Entry<String, Integer>> iterator = counts.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<String, Integer> entry = iterator.next();
      if (entry.getKey().equals(key)) {
        entry.setValue(5);
      }
    }
  }
}
