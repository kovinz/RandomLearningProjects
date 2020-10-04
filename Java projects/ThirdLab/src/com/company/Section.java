package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Section {
  private String name;
  private HashMap<String, String> values;

  Section(String name){
    this.name = name;
    values = new HashMap<>();
  }

  public String getName(){
    return name;
  }

  public void add(String key, String value){
    values.put(key, value);
  }

  public String getString(String key){
    try {
      if (values.containsKey(key)) {
        return values.get(key);
      } else {
        throw new WrongNameOfKeyException(key);
      }
    }
    catch(WrongNameOfKeyException ex){
      System.out.println(ex.getMessage());
    }
    return null;
  }

  public Integer getInteger(String key){
    try {
      if (values.containsKey(key)) {
        Integer valueInt = Integer.parseInt(values.get(key));
        return valueInt;
      } else {
        throw new WrongNameOfKeyException(key);
      }
    }
    catch (NumberFormatException e){
      System.out.println("Wrong type of value\nValue is not Integer\n" + e.getMessage());
    }
    catch(WrongNameOfKeyException ex){
      System.out.println(ex.getMessage());
    }
    return null;
  }

  public Double getDouble(String key){
    try {
    if (values.containsKey(key)) {
      Double valueDou = Double.parseDouble(values.get(key));
      return valueDou;
    } else {
      throw new WrongNameOfKeyException(key);
    }
  }
    catch (NumberFormatException e){
    System.out.println("Wrong type of value\nValue is not Double\n" + e.getMessage());
  }
    catch(WrongNameOfKeyException ex){
    System.out.println(ex.getMessage());
  }
    return null;
}
}
