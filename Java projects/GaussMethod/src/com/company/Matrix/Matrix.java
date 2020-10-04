package com.company.Matrix;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix implements Cloneable{
  private List<List<Double>> matrix;

  public Matrix(String pathName) {
    matrix = new ArrayList<>();
    try (Stream<String> stringStream = Files.lines(Paths.get(pathName))) {
      stringStream.forEachOrdered(str -> matrix.add(Arrays
              .stream(str.split(" "))
              .map(Double::parseDouble)
              .collect(Collectors.toList())));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public Matrix(){
    matrix = new ArrayList<>();
  }

  public Matrix(int height) {
    matrix = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      matrix.add(Arrays.asList(0.0));
    }
  }

  boolean checkSquare() {
    int size = matrix.size();
    return size > 1 && matrix.stream().allMatch(linearSystem -> linearSystem.size() == size);
  }

  public int size() {
    return matrix.size();
  }

  public Double get(int i, int j) {
    return matrix.get(i).get(j);
  }

  List<Double> getRow(int rowNumber) {
    return matrix.get(rowNumber);
  }

  void swapRows(int n, int m) {
    List<Double> erasedRow = matrix.set(n, matrix.get(m));
    matrix.set(m, erasedRow);
  }

  public void set(int i, int j, Double newValue) {
    matrix.get(i).set(j, newValue);
  }

  void setRow(int rowNumber, List<Double> newRow) {
    matrix.set(rowNumber, newRow);
  }

  void addRow(List<Double> doubleList) {
    matrix.add(doubleList);
  }

  public void printMatrix() {
    matrix.forEach(System.out::println);
  }

  @Override
  public Matrix clone(){
    Matrix cloneOfMatrix = new Matrix();
    matrix.stream().map(ArrayList::new).forEachOrdered(cloneOfMatrix::addRow);
    return cloneOfMatrix;
  }
}
