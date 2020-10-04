package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
  private ArrayList<Artist> artists;
  private ArrayList<Compilation> compilations;
  private ArrayList<Genre> genres;

  Catalog() {
    artists = new ArrayList<>();
    compilations = new ArrayList<>();
    genres = new ArrayList<>();
  }

  public void addArtist(Artist artist) {
    artists.add(artist);
  }

  public List<Artist> getArtists() {
    return (ArrayList<Artist>) artists.clone();
  }

  public void addCompilation(Compilation compilation) {
    compilations.add(compilation);
  }

  public List<Compilation> getCompilations() {
    return (ArrayList<Compilation>) compilations.clone();
  }

  public void addGenre(Genre genre) {
    genres.add(genre);
  }

  public ArrayList<Genre> getGenres() {
    return (ArrayList<Genre>) genres.clone();
  }

  public void addSubGenre(Genre subGenre, Genre parent) {
    parent.addSubGenre(subGenre);
  }

  public List<Album> findAlbumsByGenre(Genre genre) {
    List<Album> appropriateAlbums = new ArrayList<>();
    List<Genre> subGenres = genre.getSubGenres();
    for (Artist artist : artists) {
      for (Album album : artist.getAlbums()) {
        if (album.getGenre() == genre) {
          appropriateAlbums.add(album);
          break;
        }
        for (Genre subGenre : subGenres) {
          if (album.getGenre() == subGenre) {
            appropriateAlbums.add(album);
            break;
          }
        }
      }
    }
    return appropriateAlbums;
  }

  public List<Artist> findArtistsByCountry(String country) {
    List<Artist> appropriateArtists = new ArrayList<>();
    for (Artist artist : artists) {
      if (artist.getCountry().equals(country)) {
        appropriateArtists.add(artist);
      }
    }
    return appropriateArtists;
  }

  public List<Song> findSongsFromAlbumBySong(Song song) {
    return song.getAlbum().getSongs();
  }

  public void printGenres() {
    for (Genre genre : genres) {
      System.out.println("Main: " + genre.getName());
      for (Genre subGenre : genre.getSubGenres()) {
        System.out.println("* " + subGenre.getName());
      }
    }
  }

  public void printCompilations() {
    for (Compilation compilation : compilations) {
      System.out.println("Name: " + compilation.getName());
      for (Genre genre : compilation.getGenres()) {
        System.out.println("Genre: " + genre.getName());
      }
      for (Artist artist : compilation.getArtists()) {
        System.out.println("Artist: " + artist.getName());
      }
      for (Song song : compilation.getSongs()) {
        System.out.println("Song: " + song.getName());
      }
    }
  }

  public void printAll() {
    for (Artist artist : artists) {
      System.out.println("Artist: " + artist.getName());
      for (Album album : artist.getAlbums()) {
        System.out.println("Album: " + album.getName());
        for (Song song : album.getSongs()) {
          System.out.println("Song: " + song.getName());
        }
      }
    }
  }
}
