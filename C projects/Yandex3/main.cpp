#include <iostream>
#include <fstream>

using namespace std;

int main() {

    FILE *Fin = NULL, *Fout = NULL; // open file to read
    Fin = fopen("input.txt", "r");
    Fout = fopen("output.txt", "w");

    int n = 0;
    fscanf(Fin, "%d", &n);
    int quantity = 0;

    char ** words = new char *[n];
    for (int i = 0; i < n; i++){
        words[i] = new char [1000];
    }

    int j = 0;
    int i = 0;
    bool flag = 0;
    int c = 0;
    int b = 0;

    for (i = 0; i < n; i++){
        /**
         * reading words
         */
        for (j = 0; j < 1000; j++){
            fscanf(Fin, "%c", &words[i][j]);
            if(words[i][j]==' '||words[i][j]=='\n'||words[i][j]=='\0'){
                break;
            }
        }
        /**
         * finding out whether the word were in text
         */
        for (b = 0; b < i; b++){
            for(c = 0; c < j; c++){
                if ((words[b][c] != words[i][c])){
                    break;
                }
            }
            if (c == j){
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            quantity += --c;
        }
        else{
            for (int z = 0; z < j; z++){
                for (b = 0; b < i; b++){
                    words[b][z]
                }
            }
        }
    }

    return 0;
}