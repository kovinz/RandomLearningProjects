package ru.splat.task2.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.splat.task2.exceptions.FolderNotFoundException;

@ControllerAdvice
public class FolderNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FolderNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String folderNotFoundHandler(FolderNotFoundException ex) {
    return ex.getMessage();
  }
}