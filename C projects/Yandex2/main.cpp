#include <iostream>
#include <fstream>

using namespace std;

int main() {

    ifstream Fin;
    Fin.open("input.txt");
    ofstream Fout;
    Fout.open("output.txt");

    int n = 0;
    Fin >> n;
    string type;
    int quantity = 0;
    int * day = new int [n];
    int * hours = new int [n];
    int * minutes = new int [n];
    int * duration = new int [n];
    int * k = new int [n];

    for (int i = 0; i < n; i++){
        Fin >> type;
        if(type.size()!=7){
            continue;
        }
        Fin >> day[quantity] >> hours[quantity] >> minutes[quantity] >> duration[quantity] >> k[quantity];
    }


    Fout << day[quantity] << ' ' << hours[quantity] << ':' << minutes[quantity] << ' ' << duration[quantity] << ' ' << k[quantity];
    return 0;
}