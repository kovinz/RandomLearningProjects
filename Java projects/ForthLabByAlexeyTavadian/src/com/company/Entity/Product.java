package com.company.Entity;

public class Product {
  private String Name;

  public Product(String name) {
    this.Name = name;
  }

  public Product() {
    this.Name = " ";
  }

  public String getName() {
    return this.Name;
  }

}
