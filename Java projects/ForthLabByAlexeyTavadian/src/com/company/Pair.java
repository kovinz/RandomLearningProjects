package com.company;

public class Pair<T, K> {
  private Object Key;
  private Object Value;

  public Pair(T key, K value) {
    this.Key = key;
    this.Value = value;
  }

  public Pair() {

  }

  public Object getKey() {
    return this.Key;
  }

  public Object getValue() {
    return this.Value;
  }

  public void setKey(T key) {
    this.Key = key;
  }

  public void setValue(K value) {
    this.Value = value;
  }
}
