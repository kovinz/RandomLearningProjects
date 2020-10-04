#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("garland.in");
    Fout.open("garland.out");
    int N;
    double A;
    Fin >> N >> A;
    double left = 0;
    double right = A;
    double middle, previous, current, next, last = -1;
    bool aboveGround;
    while ((right - left) > 0.01 / (N - 1)){// condition checks that we'll be able to distinguish last element with accuracy 0.01
        middle = (left + right) / 2;
        previous = A;
        current = middle;
        aboveGround = current > 0;
        /**
         * count all the points using formula h(i+1) = 2 * h(i) - h(i-1) + 2
         * and checks whether we reached the ground
         */
        for (int i = 3 ; i <= N ; i++){
            next = 2 * current - previous + 2;
            aboveGround &= next > 0;
            previous = current;
            current = next;
        }
        /**
         * if we didn't reach the ground then we can shift top limit else shift bottom
         */
        if(aboveGround){
            right = middle;
            last = current;
        }
        else{
            left = middle;
        }
    }
    Fout << setprecision(2) << fixed << last;
    Fin.close();
    Fout.close();
    return 0;
}