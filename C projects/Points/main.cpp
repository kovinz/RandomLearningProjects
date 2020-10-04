#include <iostream>

class CPoint {
private:
    int * point;
public:
    CPoint():point(new int [2]){};

    CPoint(int first, int second){
        point = new int [2];
        point[0] = first;
        point[1] = second;
    }

    void get(){
        std::cout << point[0] << ' ' << point[1] << std::endl;
    }

    void set(int first, int second){
        point[0] = first;
        point[1] = second;
    }

    friend const CPoint operator+(const CPoint &left, const CPoint &right);

    friend const CPoint operator-(const CPoint &left, const CPoint &right);

    friend std::ostream &operator<<(std::ostream &stream, const CPoint &right);

    CPoint &operator=(const CPoint &right) {
        if (this == &right) {
            return *this;
        }
        point[0] = right.point[0];
        point[1] = right.point[1];
        return *this;
    }

    ~CPoint(){
        delete [] point;
    }
};

const CPoint operator+(const CPoint &left, const CPoint &right){
    CPoint tmp(left.point[0] + right.point[0], left.point[1] + right.point[1]);
    return tmp;
}

const CPoint operator-(const CPoint &left, const CPoint &right){
    CPoint tmp(left.point[0] - right.point[0], left.point[1] - right.point[1]);
    return tmp;
}

std::ostream &operator<<(std::ostream &stream, const CPoint &right) {
    stream << right.point[0] << ' ' << right.point [1] << std::endl;
    return stream;
}

int main() {

    CPoint p = CPoint(10, 20) + CPoint(20, 20) - CPoint(15, 15);

    std::cout << p;

    return 0;
}