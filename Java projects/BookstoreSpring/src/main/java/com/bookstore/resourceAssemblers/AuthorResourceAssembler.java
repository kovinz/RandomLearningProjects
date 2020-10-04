//package com.bookstore.resourceAssemblers;
//
//import com.bookstore.controllers.AuthorController;
//import com.bookstore.entities.Author;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.ResourceAssembler;
//import org.springframework.stereotype.Component;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@Component
//public class AuthorResourceAssembler implements ResourceAssembler<Author, Resource<Author>> {
//
//  @Override
//  public Resource<Author> toResource(Author author) {
//    return new Resource<>(author,
//            linkTo(methodOn(AuthorController.class).one(author.getId())).withSelfRel(),
//            linkTo(methodOn(AuthorController.class).all()).withRel("authors"));
//  }
//}