package ru.splat.task2.exceptions;

public class FolderNotFoundException extends RuntimeException{
  public FolderNotFoundException(Long id) {
    super("Could not find folder " + id);
  }
}