#include <iostream>
#include <fstream>

using namespace std;

const long long MAX_LONGLONG = 9223372036854775807;

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("pathsg.in"); // open input file
    Fout.open("pathsg.out"); // open output file

    int n, m, from, to, weight;
    Fin >> n >> m; // read quantity of points and ribs
    long long graph[n][n]; // create graph
    for(int i = 0; i < n; i++){ // fill graph with max or 0 if it's a loop
        for(int j = 0; j < n; j++){
            graph[i][j] = (i == j ? 0 : MAX_LONGLONG);
        }
    }
    for(int i = 0; i < m; i++){ // fill graph with actual weights from file
        Fin >> from >> to >> weight;
        graph[from - 1][to - 1] = weight;
    }
    /**
     * algorythm of Floyd-Warshall
     * for every phase check all pairs of points
     * and if current distance is bigger than distance using point k then overwrite
     */
    for(int k = 0; k < n; k++){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][k] != MAX_LONGLONG && graph[k][j] != MAX_LONGLONG){
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            Fout << graph[i][j] << " "; // print the smallest distances from one point to another
        }
        Fout << endl;
    }

    Fin.close();
    Fout.close();
    return 0;
}