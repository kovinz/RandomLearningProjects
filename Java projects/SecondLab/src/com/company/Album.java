package com.company;

public class Album extends Release{

  private Genre genre;
  private Artist artist;

  Album(String name, Artist artist, int year, Genre genre) {
    super(name, year);
    this.genre = genre;
    this.artist = artist;
    artist.addAlbum(this);
  }

  public Genre getGenre(){
    return genre;
  }

  public Artist getArtist(){
    return artist;
  }
}