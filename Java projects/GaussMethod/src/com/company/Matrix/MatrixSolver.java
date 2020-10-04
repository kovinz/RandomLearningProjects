package com.company.Matrix;


public class MatrixSolver {
  private Matrix A;
  private Matrix B;

  public MatrixSolver(Matrix a, Matrix b) {
    A = a;
    B = b;
  }

  private boolean checkSufficientCondition() {
    if (!A.checkSquare()) {
      return false;
    }
    Double sum;
    Double currentDiagElement;
    for (int i = 0; i < A.size(); i++) {
      sum = 0.0;
      currentDiagElement = A.get(i, i);
      for (int j = 0; j < A.size(); j++) {
        if (i != j) {
          sum += A.get(i, j);
        }
      }
      if (sum > currentDiagElement) {
        return false;
      }
    }
    return true;
  }

  public Matrix solveWithGauss() throws Exception {
    if (!A.checkSquare()) {
      throw new Exception("Matrix A is not square!");
    }
    int size = B.size();

    for (int column = 0; column < size; column++) {

      // find row with the max number in the column beneath current and swap
      int rowWithMaxNumber = column;
      for (int row = column + 1; row < size; row++) {
        if (Math.abs(A.get(row, column)) > Math.abs(A.get(rowWithMaxNumber, column))) {
          rowWithMaxNumber = row;
        }
      }

      // swap rows to put the row with the max number on the place of the current row
      A.swapRows(column, rowWithMaxNumber);
      B.swapRows(column, rowWithMaxNumber);

      // go through matrix and create 0 on bottom-left triangle
      for (int row = column + 1; row < size; row++) {
        double alpha = A.get(row, column) / A.get(column, column);
        B.set(row, 0, B.get(row, 0) - (alpha * B.get(column, 0)));
        for (int j = column; j < size; j++) {
          A.set(row, j, A.get(row, j) - (alpha * A.get(column, j)));
        }
      }
    }

    // go from the bottom of matrix and substitute values to get the result
    Matrix answer = new Matrix(size);
    for (int row = size - 1; row >= 0; row--) {
      double sum = 0.0;
      for (int column = row + 1; column < size; column++) {
        sum += A.get(row, column) * answer.get(column, 0);
      }
      answer.set(row, 0, (B.get(row, 0) - sum) / A.get(row, row));
    }
    return answer;
  }

  public Matrix solveWithJacobi(double epsilon) throws Exception {
    if (!checkSufficientCondition()) {
      throw new Exception("Matrix is not appropriate by the sufficient condition!");
    }
    int n = B.size();
    Matrix P = new Matrix(n);
    Matrix X = new Matrix(n);

    while (true) {
      for (int i = 0; i < n; i++) {
        double sum = B.get(i, 0);

        for (int j = 0; j < n; j++) {
          if (j != i) {
            sum -= A.get(i, j) * P.get(j, 0);
          }
        }
        X.set(i, 0, sum / A.get(i, i));
      }

      for (int i = 0; i < n; i++) {
        if (Math.abs(X.get(i, 0) - P.get(i, 0)) <= epsilon) {
          return X;
        }
      }

      P = X.clone();
    }
  }
}
