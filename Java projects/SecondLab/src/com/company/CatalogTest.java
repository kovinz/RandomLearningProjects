package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class CatalogTest {

  @Test
  public void addArtist() {
    Catalog catalog = new Catalog();

    Artist kurt = new Artist("Kurt", "USA");
    catalog.addArtist(kurt);

    Assert.assertEquals(Arrays.asList(kurt), catalog.getArtists());
  }

  @Test
  public void addGenre() {
    Catalog catalog = new Catalog();

    Genre rock = new Genre("Rock");
    catalog.addGenre(rock);

    Assert.assertEquals(Arrays.asList(rock), catalog.getGenres());
  }

  @Test
  public void findAlbumsByGenre() {
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

    Assert.assertEquals(catalog.findAlbumsByGenre(rock), Arrays.asList(nevermind));
  }

  @Test
  public void findArtistsByCountry() {
    Catalog catalog = new Catalog();

    Artist kurt = new Artist("Kurt", "USA");
    catalog.addArtist(kurt);

    Artist sting = new Artist("Sting", "Britain");
    catalog.addArtist(sting);

    Assert.assertEquals(catalog.findArtistsByCountry("USA"), Arrays.asList(kurt));
  }
}
