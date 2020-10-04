#include <iostream>
#include <fstream>

using namespace std;

int leftSearch(int *array , int key , int N){
    int left = -1 , right = N , middle;
    /**
     * while array has >1 elements go on
     * if key is bigger than middle then left border to the middle
     * else right to the middle
     */
    while(left < right - 1){
        middle = (left + right) / 2;
        if(array[middle] < key){ // < because we want to shift right border
            left = middle;
        }
        else{
            right = middle;
        }
    }
    if(right == N){ // if right == N then we didn't find element
        return -2;
    }
    if(array[right] == key){ // if we found it then return position
        return right;
    }
    else{
        return -2;
    }
}

int rightSearch(int *array , int key , int N){
    int left = -1 , right = N , middle;
    /**
     * while array has >1 elements go on
     * if key is bigger than middle then left border to the middle
     * else right to the middle
     */
    while(left < right - 1){
        middle = (left + right) / 2;
        if(array[middle] <= key){ // <= because we want to shift left border
            left = middle;
        }
        else{
            right = middle;
        }
    }
    if(left == -1){ // if left == -1 then we didn't find element
        return -2;
    }
    if(array[left] == key){ // if we found it then return position
        return left;
    }
    else{
        return -2;
    }
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("binsearch.in");
    Fout.open("binsearch.out");

    int N;
    Fin >> N; // read quantity of elements
    int *array = new int[N];
    for(int i = 0 ; i < N ; i++){ // read elements
        Fin >> array[i];
    }

    int m;
    Fin >> m; // read quantity of inquiry
    int tmp;
    /**
     * write from and to (+1 because we start from 0 element)
     */
    for(int i = 0 ; i < m ; i++){
        Fin >> tmp;
        Fout << leftSearch(array , tmp , N) + 1 << " " << rightSearch(array , tmp , N) + 1 << endl;
    }

    delete [] array;
    Fin.close();
    Fout.close();
    return 0;
}