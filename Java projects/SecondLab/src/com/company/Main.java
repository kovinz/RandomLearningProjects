package com.company;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Catalog catalog = new Catalog();

    Artist kurt = new Artist("Kurt", "USA");
    catalog.addArtist(kurt);

    Genre rock = new Genre("Rock");
    catalog.addGenre(rock);

    Genre garage = new Genre("Garage");
    catalog.addSubGenre(garage, rock);

    Album nevermind = new Album("Nevermind", kurt, 1955, garage);
    Song comeAsYouAre = new Song("Come As You Are", nevermind);
    Song lithium = new Song("Lithium", nevermind);

    Genre pop = new Genre("Pop");
    catalog.addGenre(pop);

    Artist sting = new Artist("Sting", "Britain");
    catalog.addArtist(sting);

    Album nothingLikeTheSun = new Album("...Nothing like the Sun", sting, 1970, pop);
    Song englishMan = new Song("English man in NewYork", nothingLikeTheSun);

    Compilation niceMusic = new Compilation("Nice music", 1980, Arrays.asList(comeAsYouAre, lithium, englishMan));
    catalog.addCompilation(niceMusic);

    for (Album album : catalog.findAlbumsByGenre(rock)) {
      System.out.println(album.getName());
    }
    System.out.println();

    for (Song song : catalog.findSongsFromAlbumBySong(comeAsYouAre)) {
      System.out.println(song.getName());
    }
    System.out.println();

    for (Artist artist : catalog.findArtistsByCountry("USA")) {
      System.out.println(artist.getName());
    }
  }
}
