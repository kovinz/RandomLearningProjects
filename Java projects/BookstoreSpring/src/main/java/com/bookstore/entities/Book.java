package com.bookstore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;
  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;
  private String name;
  private Integer price;
  private String material;
  private Integer pages;
  private String size;
  private Integer quantity;
  private Integer yearOfPublishing;

  public Book(Publisher publisher, Author author, Subject subject,
              String name, Integer price, String material, Integer pages,
              String size, Integer quantity, Integer yearOfPublishing) {
    this.publisher = publisher;
    this.author = author;
    this.subject = subject;
    this.name = name;
    this.price = price;
    this.material = material;
    this.pages = pages;
    this.size = size;
    this.quantity = quantity;
    this.yearOfPublishing = yearOfPublishing;
  }
}