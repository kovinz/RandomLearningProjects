#include <iostream>
#include <cstdio>
#include <cstring>
#include <stdexcept>
#include <limits>

using namespace std;

template<typename T>
class Vector;

template<typename T>
class Iterator {
    friend class Vector<T>;

public:

    bool operator==(Iterator<T> &second) {
        return currentPosition == second.currentPosition;
    }

    bool operator!=(Iterator<T> &second) {
        return currentPosition != second.currentPosition;
    }

    Iterator<T> &operator++() {
        if (currentPosition == vector.size()) {
            throw out_of_range("End of vector.");
        }
        ++currentPosition;
        return *this;
    }

    Iterator<T> operator++(int) {
        Iterator<T> tmp(*this);
        ++(*this);
        return tmp;
    }

    Iterator<T> &operator--() {
        if (currentPosition == 0) {
            throw out_of_range("Start of vector.");
        }
        --currentPosition;
        return *this;
    }

    Iterator<T> operator--(int) {
        Iterator<T> tmp(*this);
        --(*this);
        return tmp;
    }

    T &operator*() {
        return vector[currentPosition];
    }

    T *operator->() {
        return &vector[currentPosition];
    }

private:

    Iterator(Vector<T> &vector, unsigned int start) : vector(vector), currentPosition(start) {}

    Vector<T> &vector;
    unsigned int currentPosition;
};

template<typename T>
class Vector {
public:

friend class Iterator<T>;

    explicit Vector(unsigned int openingSize) {
        massive = new T[openingSize];
        arrSize = openingSize;
        quantityElements = 0;
    }

    Vector() : Vector(8) {}

    void sort() {
        quickSort(massive, 0, quantityElements - 1);
    }

    unsigned int size() const {
        return quantityElements;
    }

    void push_back(T x) {
        checkSize();
        massive[quantityElements++] = x;
    }

    T pop_back() {
        if (empty()) {
            throw out_of_range("Vector is empty");
        }
        return massive[--quantityElements];
    }

    void push_front(T x) {
        checkSize();
        for (unsigned int i = quantityElements; i > 0; --i) {
            massive[i] = massive[i - 1];
        }
        massive[0] = x;
        ++quantityElements;
    }

    void pop_front() {
        if (empty()) {
            throw out_of_range("Vector is empty");
        }
        for (unsigned int i = 1; i < quantityElements; ++i) {
            massive[i - 1] = massive[i];
        }
        --quantityElements;
    }

    bool empty() const {
        return quantityElements == 0;
    }

    T max() {
        if (quantityElements == 0) {
            return std::numeric_limits<T>::min();
        }
        int tmp = 0;
        for (unsigned int i = 1; i < quantityElements; ++i) {
            if (massive[i] > massive[tmp]) {
                tmp = i;
            }
        }
        return massive[tmp];
    }

    T min() {
        if (quantityElements == 0) {
            return std::numeric_limits<T>::max();
    }
        int tmp = 0;
        for (unsigned int i = 1; i < quantityElements; ++i) {
            if (massive[i] < massive[tmp]) {
                tmp = i;
            }
        }
        return massive[tmp];
    }

    T &operator[](unsigned int index) const {
        if (index >= quantityElements || index < 0) {
            throw out_of_range("Index is beyond required range");
        }
        return massive[index];
    }

    Iterator<T> begin() {
        return Iterator<T>(*this, 0);
    }

    Iterator<T> end() {
        return Iterator<T>(*this, quantityElements);
    }

private:

    void quickSort(T *s_arr, int first, int last) {
        if (first < last) {
            int left = first, right = last, middle = s_arr[(left + right) / 2];
            do {
                while (s_arr[left] < middle) left++;
                while (s_arr[right] > middle) right--;
                if (left <= right) {
                    int tmp = s_arr[left];
                    s_arr[left] = s_arr[right];
                    s_arr[right] = tmp;
                    left++;
                    right--;
                }
            } while (left <= right);
            quickSort(s_arr, first, right);
            quickSort(s_arr, left, last);
        }
    }

    void checkSize() {
        if (arrSize == quantityElements) {
            auto *newArr = new T[arrSize * 2];
            memcpy(newArr, massive, sizeof(T) * arrSize);
            delete[] massive;
            massive = newArr;
            arrSize *= 2;
        }
    }

    T *massive;
    unsigned int arrSize;
    unsigned int quantityElements;
};

int main() {

    Vector<int> vec;

    for (size_t i = 0; i < 25; i++) {
        vec.push_back(i - 25);
        vec.push_front(i);
    }

    cout << "initial vector is: " << endl;
    for (auto i : vec) {
        cout << i << " ";
    }

    vec.sort();
    vec[10] = 999999;
    cout << endl << "sorted vector with new number on 10 position is: " << endl;
    for (auto i : vec) {
        cout << i << " ";
    }

    for (size_t i = 0; i < 10; i++) {
        vec.pop_back();
        vec.pop_front();
    }

    cout << endl << "vector after some pops is: " << endl;
    for (auto i : vec) {
        cout << i << " ";
    }

    cout << endl << "minimum is: " << vec.min();
    cout << endl << "maximum is: " << vec.max();

    system("pause");
    return 0;
}