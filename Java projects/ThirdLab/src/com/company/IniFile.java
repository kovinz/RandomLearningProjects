package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IniFile {
  private List<Section> sections;

  IniFile(String path){
    sections = new ArrayList<>();
    parseIni(path);
  }

  private void parseIni(String path) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String line;
      Section currentSection = null;
      Matcher matcher;
      Pattern sectionPattern = Pattern.compile( "\\[([a-zA-Z0-9_]*)]" );
      Pattern keyValuePattern = Pattern.compile( "([a-zA-Z0-9_]*)\\s*=\\s*([^ ;]*)\\s*;*.*" );

      while ((line = reader.readLine()) != null) {
        matcher = sectionPattern.matcher(line);
        if (matcher.matches()) {
          Section newSection = new Section(matcher.group(1));
          sections.add(newSection);
          currentSection = newSection;
        } else if (currentSection != null) {
          matcher = keyValuePattern.matcher(line);
          if (matcher.matches()) {
            String key = matcher.group(1);
            String valueStr = matcher.group(2);
            currentSection.add(key, valueStr);
          }
        }
      }
      reader.close();
    }catch (FileNotFoundException ex) {
      System.out.println("Wrong path to file: " + ex.getMessage());
    }
    catch (IOException e){
      System.out.println("Went through the end of file: " + e.getMessage());
    }
  }

  public String getString(String nameOfSection, String key){
    try {
      for (Section section : sections) {
        if (section.getName().equals(nameOfSection)) {
          return section.getString(key);
        }
      }
      throw new WrongNameOfSectionException(nameOfSection);
    }
    catch (WrongNameOfSectionException ex){
      System.out.println(ex.getMessage());
    }
    return null;
  }

  public Integer getInteger(String nameOfSection, String key){
    try{
      for (Section section : sections){
      if (section.getName().equals(nameOfSection)){
        return section.getInteger(key);
      }
    }
    throw new WrongNameOfSectionException(nameOfSection);
  }
    catch (WrongNameOfSectionException ex){
    System.out.println(ex.getMessage());
  }
    return null;
  }

  public Double getDouble(String nameOfSection, String key){
    try{
      for (Section section : sections){
      if (section.getName().equals(nameOfSection)){
        return section.getDouble(key);
      }
    }
    throw new WrongNameOfSectionException(nameOfSection);
  }
    catch (WrongNameOfSectionException ex){
    System.out.println(ex.getMessage());
  }
    return null;
  }
}
