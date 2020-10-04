#include <iostream>
#include <fstream>

using namespace std;

int main() {

    ifstream Fin;
    Fin.open("sort.in.txt");

    size_t N;
    Fin >> N;
    int * array = new int [N];

    for (int i = 0; i < N; i++){
        Fin >> array[i];
    }


    ofstream Fout;
    Fout.open("sort.out.txt");

    Fin.close();
    Fout.close();
    return 0;
}