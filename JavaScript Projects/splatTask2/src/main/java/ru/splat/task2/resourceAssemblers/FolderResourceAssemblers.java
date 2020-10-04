//package ru.splat.task2.resourceAssemblers;
//
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.ResourceAssembler;
//import org.springframework.stereotype.Component;
//import ru.splat.task2.controllers.FolderController;
//import ru.splat.task2.models.Folder;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@Component
//public class FolderResourceAssemblers implements ResourceAssembler<Folder, Resource<Folder>> {
//  @Override
//  public Resource<Folder> toResource(Folder folder){
//    return new Resource<>(folder,
//            linkTo(methodOn(FolderController.class).one(folder.getId())).withSelfRel(),
//            linkTo(methodOn(FolderController.class).getChildren(folder.getId())).withRel("children"),
//            linkTo(methodOn(FolderController.class).getChildren(folder.getParent().getId())).withRel("parent"));
//  }
//}





//package com.bookstore.resourceAssemblers;
//
//import com.bookstore.controllers.AuthorController;
//import com.bookstore.models.Author;
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