package com.company;

import com.company.Matrix.Matrix;
import com.company.Matrix.MatrixSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

  public static void main(String[] args) {
    Matrix matrixA = new Matrix("A.txt");
    Matrix matrixB = new Matrix("B.txt");
    MatrixSolver matrixSolver = new MatrixSolver(matrixA, matrixB);
    try {
      Matrix gaussMethod = matrixSolver.solveWithGauss();
      System.out.println("Solved with gauss");
      gaussMethod.printMatrix();
      Matrix jacobiMethod = matrixSolver.solveWithJacobi(10e-5);
      System.out.println("Solved with jacobi");
      jacobiMethod.printMatrix();
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
