package com.company;

public class WrongNameOfSectionException extends Exception {
  WrongNameOfSectionException(String name){
    super("Wrong name of section: " + name);
  }
}
