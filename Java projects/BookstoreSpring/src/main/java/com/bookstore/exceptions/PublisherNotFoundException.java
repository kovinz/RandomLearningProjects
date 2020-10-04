package com.bookstore.exceptions;

public class PublisherNotFoundException extends RuntimeException {
  public PublisherNotFoundException(Long id) {
    super("Could not find publisher " + id);
  }
}