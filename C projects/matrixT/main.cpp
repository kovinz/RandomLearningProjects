#include<iostream>
#include <fstream>

using namespace std;

template <typename T>
class Matrix {
private:
    int K;
    int M;
    T **square;
public:
/**
 * Without parameters create matrix 3 x 3
 */
    Matrix() : K(3), M(3) {
        square = new T *[K];
        for (int i = 0; i < K; i++) {
            square[i] = new T[M];
        }
    }
/**
 * With parameters create matrix K x M
 * @param k high
 * @param m width
 */
    Matrix(int k, int m) : K(k), M(m) {
        square = new T *[K];
        for (int i = 0; i < K; i++) {
            square[i] = new T[M];
        }
    }
/**
 * clear memory
 */
    ~Matrix() {
        for (int i = 0; i < K; i++) {
            delete[] square[i];
        }
        delete[] square;
        square = nullptr;
    }
/**
 * read matrix from file (matrix with the right size should be created before reading)
 */
    void read() {
        ifstream Fin("Matrix_to_read.txt");

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < M; j++) {
                Fin >> square[i][j];
            }
        }
        Fin.close();
    }
/**
 * set needed value to the specific element of matrix
 */
    void set(T value, int high, int width) {
        square[high][width] = value;
    }

    T get(int h, int w) const{
        return square[h][w];
    }
/**
 * transpose matrix
 */
    void transpose() {
        T ** new_sqare = new T * [this->M];

        new_sqare[0] = new T [this->M * this->K];

        for (int i = 1; i < M; i++){
            new_sqare[i] = new_sqare[i - 1] + K;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                new_sqare[i][j] = square[j][i];
            }
        }

        this->clear();

        swap(K, M);

        square = new_sqare;
    }
/**
 * return quantity of lines (high)
 */
    int lines() const{
        return K;
    }
/**
 * return quantity of columns (width)
 */
    int columns() const{
        return M;
    }
/**
 * clear memory
 */
    void clear() {
        for (int i = 0; i < K; i++) {
            delete[] square[i];
        }
        delete[] square;
        square = nullptr;
    }
/**
 * operator overloading
 */
    Matrix &operator=(const Matrix &right) {
        if (this == &right) {
            return *this;
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < M; j++) {
                square[i][j] = right.square[i][j];
            }
        }
        return *this;
    }
};


template <typename T>
const Matrix<T> operator+(const Matrix<T> &left, const Matrix<T> &right) {

    Matrix<T> Answer(right.lines(), right.columns());

    for (int i = 0; i < right.lines(); i++) {
        for (int j = 0; j < right.columns(); j++) {
            Answer.set(left.get(i, j) + right.get(i, j), i, j);
        }
    }

    return Answer;
}
template <typename T>
const Matrix<T> operator-(const Matrix<T> &left, const Matrix<T> &right) {

    Matrix<T> Answer(right.lines(), right.columns());

    for (int i = 0; i < right.lines(); i++) {
        for (int j = 0; j < right.columns(); j++) {
            Answer.set(left.get(i, j) - right.get(i, j), i, j);
        }
    }

    return Answer;
}
template <typename T>
const Matrix<T> operator*(const Matrix<T> &left, const Matrix<T> &right) {

    Matrix<T> Answer(left.lines(), right.columns());
    T tmp;

    for (int i = 0; i < left.lines(); i++) {
        for (int j = 0; j < right.columns(); j++) {
            tmp = 0;
            for (int k = 0; k < left.columns(); k++) {
                tmp += left.get(i, k) * right.get(k, j);
            }
            Answer.set(tmp, i, j);
        }
    }

    return Answer;
}
template <typename T>
Matrix<T> &operator+=(Matrix<T> &left, const Matrix<T> &right) {

    for (int i = 0; i < left.lines(); i++) {
        for (int j = 0; j < left.columns(); j++) {
            left.set(left.get(i, j) + right.get(i, j), i, j);
        }
    }

    return left;
}
template <typename T>
Matrix<T> &operator-=(Matrix<T> &left, const Matrix<T> &right) {

    for (int i = 0; i < left.lines(); i++) {
        for (int j = 0; j < left.columns(); j++) {
            left.set(left.get(i, j) - right.get(i, j), i, j);
        }
    }

    return left;
}
template <typename T>
Matrix<T> &operator*=(Matrix<T> &left, const Matrix<T> &right) {
    int tmp;

    for (int i = 0; i < left.K; i++) {
        for (int j = 0; j < right.M; j++) {
            tmp = 0;
            for (int k = 0; k < left.M; k++) {
                tmp += left.get(i, k) * right.get(k, j);
            }
            left.set(tmp, i, j);
        }
    }

    for (int i = 0; i < left.K; i++) {
        for (int j = left.M; j > right.M; j--) {
            delete &left.square[i][j];
            left.M--;
        }
    }

    return left;
}
template <typename T>
istream &operator>>(istream &stream, Matrix<T> &left) {
    T tmp;
    for (int i = 0; i < left.lines(); i++) {
        for (int j = 0; j < left.columns(); j++) {
            stream >> tmp;
            left.set(tmp, i, j);
        }
    }
    return stream;
}
template <typename T>
ostream &operator<<(ostream &stream, Matrix<T> &left) {

    for (int i = 0; i < left.lines(); i++) {
        for (int j = 0; j < left.columns(); j++) {
            stream << left.get(i, j) << ' ';
        }
        cout << endl;
    }
    return stream;
}

int main() {

    Matrix<double> obj1;
    Matrix<char> obj2;
    Matrix<double> obj3;
    int tmp;

    cin >> obj2;
    obj2.transpose();
    cout << obj2;

    obj3.read();
    obj3 += obj3;
    cout << obj3;

    cin >> tmp;
    return 0;
}