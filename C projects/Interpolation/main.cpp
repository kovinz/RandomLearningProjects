//Cubic spline interpolation program
//when we have two columns of data x and y in input file:
//
//x0 y0
//x1 y1
//...
//xn yn
//
//and we want to find such function f(x)
//where f(xi) = yi
//and f(x) is cubic function on every [x_k-1, x_k] segment
//and f(x), f'(x), f''(x) are continual
//the result is four columns of cubic polinom coefficients

#include <math.h>
#include <stdio.h>
#include <process.h>
#include <fstream>
#include <iostream>

using namespace std;

double *x, *y, *h, *l, *delta, *lambda, *c, *d, *b;
int N;
char filename[256];
FILE *InFile = nullptr;

void readmatrix() {
    int i = 0;
    //read matrixes a and b from input file
    for (i = 0; i < N + 1; i++) {
        fscanf(InFile, "%f", &x[i]);
        fscanf(InFile, "%f", &y[i]);
    }
}

void allocmatrix() {
    //allocate memory for matrixes
    x = new double[N + 1];
    y = new double[N + 1];
    h = new double[N + 1];
    l = new double[N + 1];
    delta = new double[N + 1];
    lambda = new double[N + 1];
    c = new double[N + 1];
    d = new double[N + 1];
    b = new double[N + 1];
}

void freematrix() {
    delete[] x;
    delete[] y;
    delete[] h;
    delete[] l;
    delete[] delta;
    delete[] lambda;
    delete[] c;
    delete[] d;
    delete[] b;
}

void printresult() {
    int k = 0;
    printf("\nA[k]\tB[k]\tC[k]\tD[k]\n");
    for (k = 1; k <= N; k++) {
        printf("%f\t%f\t%f\t%f\n\n", y[k], b[k], c[k], d[k]);
    }
}

void testresult() {
    double start = x[0];
    double end = x[N];
    double step = (end - start) / 20;
    FILE *OutFile = fopen("test.txt", "wt");
    for (double s = start; s <= end; s += step) {
        //find k, where s in [x_k-1; x_k]
        int k = 1;
        for (; k <= N; k++) {
            if (s >= x[k - 1] && s <= x[k]) {
                break;
            }
        }
        double F = y[k] + b[k] * (s - x[k]) + c[k] * pow(s - x[k], 2) + d[k] * pow(s - x[k], 3);
        fprintf(OutFile, "%f\t%f\n", s, F);
    }
    fclose(OutFile);
}

void cls() {
    for (int i = 0; i < 25; i++) printf("\n");
}

int main() {
    int k = 0;
    cls();
    ifstream InFile("input.txt"); // открыли файл для чтения
    N = 5;
    allocmatrix();
    readmatrix();
    for (k = 1; k <= N; k++) {
        h[k] = x[k] - x[k - 1];
        if (h[k] == 0) {
            printf("\nError, x[%d]=x[%d]\n", k, k - 1);
            return 1;
        }
        l[k] = (y[k] - y[k - 1]) / h[k];
    }
    delta[1] = -h[2] / (2 * (h[1] + h[2]));
    lambda[1] = 1.5 * (l[2] - l[1]) / (h[1] + h[2]);
    for (k = 3; k <= N; k++) {
        delta[k - 1] = -h[k] / (2 * h[k - 1] + 2 * h[k] + h[k - 1] * delta[k - 2]);
        lambda[k - 1] = (3 * l[k] - 3 * l[k - 1] - h[k - 1] * lambda[k - 2]) /
                        (2 * h[k - 1] + 2 * h[k] + h[k - 1] * delta[k - 2]);
    }
    c[0] = 0;
    c[N] = 0;
    for (k = N; k >= 2; k--) {
        c[k - 1] = delta[k - 1] * c[k] + lambda[k - 1];
    }
    for (k = 1; k <= N; k++) {
        d[k] = (c[k] - c[k - 1]) / (3 * h[k]);
        b[k] = l[k] + (2 * c[k] * h[k] + h[k] * c[k - 1]) / 3;
    }
    printresult();
    testresult();
    freematrix();
    return 0;
}