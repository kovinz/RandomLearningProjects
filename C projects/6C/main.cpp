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
     * fill table with 0
     */
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            table[i][j] = 0;
        }
    }
    /**
     * read from file and fill needed position with 1
     * if parallel rib was created already then print YES
     */
    for(int i = 0 ; i < m ; i++){
        Fin >> x >> y;
        if(table[y - 1][x - 1] || table[x - 1][y - 1]){
            Fout << "YES";
            Fin.close();
            Fout.close();
            return 0;
        }
        table[x - 1][y - 1] = 1;
    }
    // if we didn't end inside previous for then print NO
    Fout << "NO";
    Fin.close();
    Fout.close();
    return 0;
}