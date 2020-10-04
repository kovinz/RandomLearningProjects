//package com.bookstore.controllers;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.bookstore.entities.Author;
//import com.bookstore.exceptions.AuthorNotFoundException;
//import com.bookstore.repositories.AuthorRepository;
//import com.bookstore.resourceAssemblers.AuthorResourceAssembler;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.Resources;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@RestController
//public class AuthorController {
//
//  private final AuthorRepository repository;
//  private final AuthorResourceAssembler assembler;
//
//  public AuthorController(AuthorRepository repository,
//                            AuthorResourceAssembler assembler) {
//
//    this.repository = repository;
//    this.assembler = assembler;
//  }
//
//  // Aggregate root
//
//  @GetMapping("/authors")
//  public Resources<Resource<Author>> all() {
//
//    List<Resource<Author>> authors = repository.findAll().stream()
//            .map(assembler::toResource)
//            .collect(Collectors.toList());
//
//    return new Resources<>(authors,
//            linkTo(methodOn(AuthorController.class).all()).withSelfRel());
//  }
//
//  @PostMapping("/authors")
//  public ResponseEntity<?> newAuthor(@RequestBody Author newAuthor) throws URISyntaxException {
//
//    Resource<Author> resource = assembler.toResource(repository.save(newAuthor));
//
//    return ResponseEntity
//            .created(new URI(resource.getId().expand().getHref()))
//            .body(resource);
//  }
//
//  // Single item
//
//  @GetMapping("/authors/{id}")
//  public Resource<Author> one(@PathVariable Long id) {
//
//    Author author = repository.findById(id)
//            .orElseThrow(() -> new AuthorNotFoundException(id));
//
//    return assembler.toResource(author);
//  }
//
//  @PutMapping("/authors/{id}")
//  public ResponseEntity<?> replaceEmployee(@RequestBody Author newAuthor, @PathVariable Long id) throws URISyntaxException {
//
//    Author updatedAuthor = repository.findById(id)
//            .map(author -> {
//              author.setName(newAuthor.getName());
//              return repository.save(author);
//            })
//            .orElseThrow(() -> new AuthorNotFoundException(id));
//            .orElseGet(() -> {
//              newAuthor.setId(id);
//              return repository.save(newAuthor);
//            });
//
//    Resource<Author> resource = assembler.toResource(updatedAuthor);
//
//    return ResponseEntity
//            .created(new URI(resource.getId().expand().getHref()))
//            .body(resource);
//  }
//
//  @DeleteMapping("/authors/{id}")
//  public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
//
//    repository.deleteById(id);
//
//    return ResponseEntity.noContent().build();
//  }
//}