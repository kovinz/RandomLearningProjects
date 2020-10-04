#include <iostream>
#include <fstream>

using namespace std;

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("input.txt");
    Fout.open("output.txt");

    int n , m , x , y;
    Fin >> n >> m;
    int table[n][n];
    /**
     * put 0 to all elements of the table
     */
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            table[i][j] = 0;
        }
    }
    /**
     * read x and y from the file and write 1 there
     */
    for(int i = 0 ; i < m ; i++){
        Fin >> x >> y;
        table[x - 1][y - 1] = 1;
    }
    /**
     * print table to output file
     */
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            Fout << table[i][j] << " ";
        }
        Fout << endl;
    }

    Fin.close();
    Fout.close();
    return 0;
}