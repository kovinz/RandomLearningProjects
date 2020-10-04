package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Compilation extends Release{

  private Set<Artist> artists;
  private Set<Genre> genres;

  Compilation(String name, int year){
    super(name, year);
    artists = new HashSet<>();
    genres = new HashSet<>();
  }

  Compilation(String name, int year, List<Song> songs){
    super(name, year);
    artists = new HashSet<>();
    genres = new HashSet<>();
    for (Song song : songs){
      addSong(song);
    }
  }

  @Override
  public void addSong(Song song){
    super.addSong(song);
    artists.add(song.getAlbum().getArtist());
    genres.add(song.getAlbum().getGenre());
  }

  public Set<Artist> getArtists(){
    return artists;
  }

  public Set<Genre> getGenres(){
    return genres;
  }

}
