package com.company;

public class Song {
  private String name;
  private Album album;

  Song(String name, Album album){
    this.name = name;
    this.album = album;
    album.addSong(this);
  }

  public String getName(){
    return name;
  }

  public Album getAlbum(){
    return album;
  }
}
