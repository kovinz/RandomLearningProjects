#include <iostream>
#include <fstream>

using namespace std;


int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("input.txt");
    Fout.open("output.txt");

    int n, m;
    Fin >> n >> m; // read size of maze
    char symbol;
    string pathToExit;
    int exitFirst, exitSecond; // to remember point of finish
    int maze[n + 1][m + 1]; // create matrix of maze

    for(int i = 0; i < n + 1; i++){
        for(int j = 0; j < m + 1; j++){
            if(i == 0  || j == 0 ){ // create frame
                maze[i][j] = -1;
            }
            else{ // read symbol if we can go through print -1 else print -2
                Fin >> symbol;
                switch (symbol) {
                    case 'T':
                        exitFirst = i;
                        exitSecond = j;
                        maze[i][j] = -1;
                        break;
                    case '.':
                        maze[i][j] =-1;
                        break;
                    case '#':
                        maze[i][j] = -2;
                        break;
                    case 'S':
                        maze[i][j] = 1;
                        break;
                }
            }
        }
    }


    for(int length = 1; length < m * n; length++){ // go through all points in maze
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){ // print to points value of length 1 more than previous
                if(maze[i][j] == length){
                    if(maze[i][j - 1] == -1){
                        maze[i][j - 1] = length + 1;
                    }
                    if(maze[i - 1][j] == -1){
                        maze[i - 1][j] = length + 1;
                    }
                    if(maze[i + 1][j] == -1){
                        maze[i + 1][j] = length + 1;
                    }
                    if(maze[i][j + 1] == -1){
                        maze[i][j + 1] = length + 1;
                    }
                }
            }
        }
    }
    if(maze[exitFirst][exitSecond] == -1){ // if we have 0 in finish that means that we didn't come there
        Fout << -1;
    }

    else{
        int current = maze[exitFirst][exitSecond];
        Fout << current - 1 << endl; // print quantity steps to exit
        while(current != 1){ // while we didn't come to start go in reverse direction remembering path
            if(maze[exitFirst - 1][exitSecond] == current - 1){
                pathToExit += "D";
                exitFirst--;
            }
            else if(maze[exitFirst][exitSecond - 1] == current - 1){
                pathToExit += "R";
                exitSecond--;
            }
            else if (maze[exitFirst + 1][exitSecond] == current - 1){
                pathToExit += "U";
                exitFirst++;
            }
            else if(maze[exitFirst][exitSecond + 1] == current - 1){
                pathToExit += "L";
                exitSecond++;
            }
            current--;
        }
    }
    for(int i = pathToExit.size() - 1; i >= 0; i--){ // print path which we remembered in string
        Fout << pathToExit[i];
    }
    Fin.close();
    Fout.close();
    return 0;
}