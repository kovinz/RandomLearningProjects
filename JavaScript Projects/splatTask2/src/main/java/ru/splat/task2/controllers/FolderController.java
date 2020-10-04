package ru.splat.task2.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.splat.task2.exceptions.FolderNotFoundException;
import ru.splat.task2.models.Folder;
import ru.splat.task2.repositories.FolderRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

  private final FolderRepository repository;

  public FolderController(FolderRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/folders")
  public List<Folder> all() {
    return repository.findAllByParentId(1);
  }

  @GetMapping("/folders/{id}/children")
  public List<Folder> getChildren(@PathVariable Long id) {

    List<Folder> folders = repository.findAllByParentId(id);

    return folders;
  }

  @GetMapping("/folders/{id}")
  public Folder one(@PathVariable Long id) {

    Optional<Folder> folder = repository.findById(id);
    if (!folder.isPresent()){
      throw new FolderNotFoundException(id);
    }
    return folder.get();
  }

  @DeleteMapping("/folders/{id}")
  public void deleteFolder(@PathVariable long id) {
    repository.deleteById(id);
  }

  @PostMapping("/folders")
  public ResponseEntity<Object> createFolder(@RequestBody Folder folder) {
    Folder savedStudent = repository.save(folder);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedStudent.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping("/folders/{id}")
  public ResponseEntity<Object> updateFolder(@RequestBody Folder folder, @PathVariable long id) {

    Optional<Folder> folderOptional = repository.findById(id);

    if (!folderOptional.isPresent())
      return ResponseEntity.notFound().build();

    folder.setId(id);

    repository.save(folder);

    return ResponseEntity.noContent().build();
  }
}
