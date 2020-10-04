package com.company;

import java.util.LinkedList;
import java.util.List;

public abstract class Release {
  private String name;
  private int year;
  private List<Song> songs;

  Release(String name, int year) {
    this.name = name;
    this.year = year;
    this.songs = new LinkedList<>();
  }

  public String getName(){
    return name;
  }

  public int getYear(){
    return year;
  }

  protected void addSong(Song song){
    songs.add(song);
  }

  public List<Song> getSongs(){
    return songs;
  }
}
