//package ru.splat.task2.forms;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonView;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import ru.splat.task2.models.Folder;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class FolderForm {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//  private String title;
//
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JsonIgnore
//  private Folder parent;
//
//  public FolderForm(String name, Folder parent) {
//    this.name = name;
//    this.parent = parent;
//  }
//}
