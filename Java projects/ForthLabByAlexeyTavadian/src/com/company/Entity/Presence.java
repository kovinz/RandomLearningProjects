package com.company.Entity;

public class Presence {
  private Product product;
  private double price;
  private int quantity;

  public Presence(Product product, double price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
  }

  public Object getProduct() {
    return this.product;
  }

  public Object getPrice() {
    return this.price;
  }

  public Object GetExtra() {
    return this.quantity;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
