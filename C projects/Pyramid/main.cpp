#include <iostream>
#include <fstream>

using namespace std;

int main() {

    ifstream Fin; // open input file
    Fin.open("isheap.in");

    int N = 0;
    Fin >> N; // read size of array

    int * pyramid = new int [++N]; // create array of size N+1 because we need check from variable with index 1
    int flag = 0;

    for (int i = 1; i < N; i++){ // read the array
        Fin >> pyramid[i];
    }
    /*
     * go through array if element on top is bigger than two under it then raise flag
     */
    for (int i = 1; i < (N/2-1); i++){
        if ((pyramid[i] > pyramid[2*i])||(pyramid[i] > pyramid[2*i+1])){
            flag = 1;
        }
    }

    ofstream Fout;
    Fout.open("isheap.out"); // open output file
    if (flag == 1){ // if flag was raised then write NO otherwise write YES
        Fout << "NO";
    }
    else{
        Fout << "YES";
    }

    Fin.close(); // close files
    Fout.close();
    return 0;
}