package com.company;

public class WrongNameOfKeyException extends Exception {
  WrongNameOfKeyException(String nameOfKey){
    super("Wrong name of key: " + nameOfKey);
  }
}
