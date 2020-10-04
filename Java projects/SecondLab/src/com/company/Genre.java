package com.company;

import java.util.LinkedList;
import java.util.List;

public class Genre {
  private String name;
  private List<Genre> subGenres;

  Genre(String name) {
    this.name = name;
    subGenres = new LinkedList<>();
  }

  public void addSubGenre(Genre subGenre){
    subGenres.add(subGenre);
  }

  public String getName(){
    return name;
  }

  public List<Genre> getSubGenres(){
    return subGenres;
  }
}
