package com.company;

import java.util.LinkedList;
import java.util.List;

public class Artist {
  private String name;
  private String country;
  private List<Album> albums;

  Artist(String name, String country){
    this.name = name;
    this.country = country;
    albums = new LinkedList<>();
  }

  protected void addAlbum(Album album){
    albums.add(album);
  }

  public String getName(){
    return name;
  }

  public String getCountry(){
    return country;
  }

  public List<Album> getAlbums(){
    return albums;
  }
}
