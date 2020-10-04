#include <iostream>

using namespace std;

template <class T>
class fraction {
private:
    T * number;
public:
    fraction():number(new T [2]){};
    fraction(T numerator, T denominator){
        number = new T [2];
        number[0] = numerator;
        number[1] = denominator;
    }

    void get(){
        cout << number[0] << endl;
        cout << number[1] << endl;
    }

    void set(T numerator, T denominator){
        number[0] = numerator;
        number[1] = numerator;
    }

    void simplification(){
        T numerator = number[0];
        T denominator = number[1];

        while(numerator != 0 && denominator != 0){
            numerator >= denominator ? numerator %= denominator : denominator %= numerator;
        }

        number[0] /= (numerator + denominator);
        number[1] /= (numerator + denominator);
    }

    const fraction operator+(const fraction &right){
        fraction<T> tmp(number[0] * right.number[1] + right.number[0] * number[1], number[1] * right.number[1]);
        return tmp;
    }

    fraction &operator=(const fraction &right) {
        if (this == &right) {
            return *this;
        }
        number[0] = right.number[0];
        number[1] = right.number[1];
        return *this;
    }

    ~fraction(){
        delete [] number;
    }
};

int main() {

    fraction<int> obj3 = fraction<int>(4, 5) + fraction<int>(7, 8);
    obj3.get();
    obj3.simplification();
    obj3.get();

    return 0;
}