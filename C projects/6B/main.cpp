#include <iostream>
#include <fstream>

using namespace std;

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("input.txt");
    Fout.open("output.txt");

    int n;
    Fin >> n;
    int table[n][n];
    /**
     * fill table by reading from file
     */
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            Fin >> table[i][j];
        }
    }
    /**
     * check the table if we find that table isn't symmetrical or 1 on diagonal then print NO and exit
     */
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j <= i ; j++){
            if(table[i][j] != table[j][i] || ((i == j) && table[i][j] != 0)){
                Fout << "NO";
                Fin.close();
                Fout.close();
                return 0;
            }
        }
    }
    // if we didn't find out that smth is wrong then print YES
    Fout << "YES";
    Fin.close();
    Fout.close();
    return 0;
}