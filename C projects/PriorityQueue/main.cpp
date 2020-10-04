#include <iostream>
#include <fstream>

using namespace std;

pair<int, int> heap_arr[10000005];
int n, key_counter, key_arr[10000005];
/**
 * sort array by not decreasing
 */
void siftUp(int v){
    while (v > 0 && heap_arr[(v - 1) / 2].first > heap_arr[v].first) {
        swap(key_arr[heap_arr[(v - 1) / 2].second], key_arr[heap_arr[v].second]);
        swap(heap_arr[(v - 1) / 2], heap_arr[v]);
        v = (v - 1) / 2;
    }
}
/**
 * swap element with index v with min bigger element
 */
void siftDown(int v){
    while (true) {
        int c1 = 2 * v + 1, c2 = 2 * v + 2;
        if (c1 >= n){
            return;
        }
        if (c2 >= n){
            c2 = c1;
        }
        if (heap_arr[v].first <= heap_arr[c1].first && heap_arr[v].first <= heap_arr[c2].first){
            return;
        }
        int min = c1;
        if (heap_arr[c2].first < heap_arr[c1].first){
            min = c2;
        }
        swap(key_arr[heap_arr[min].second], key_arr[heap_arr[v].second]);
        swap(heap_arr[min], heap_arr[v]);
        v = min;
    }

}

void add(int a){
    heap_arr[n].first = a; // add value to first element of pair
    heap_arr[n].second = key_counter; // add key to the second element of pair
    key_arr[key_counter] = n++; // print in key_array index of element with this value of key
    siftUp(n - 1); // sort array by not decreasing
}

int main(){
    ifstream Fin;
    Fin.open("priorityqueue.in");
    ofstream Fout;
    Fout.open("priorityqueue.out");
    string command;
    while (Fin >> command) { // read command
        key_counter++;
        if (command == "push"){ // add k to the array
            int k;
            Fin >> k;
            add(k);
        } else if (command == "decrease-key"){
            int num, x;
            Fin >> num >> x;
            heap_arr[key_arr[num]].first = x; // to the heap with needed index (find by key) print x
            siftUp(key_arr[num]); // sort array by not decreasing
        } else if (command == "extract-min"){
            if (n == 0) {
                Fout << "*\n";
            }
            else{
                Fout << heap_arr[0].first << endl; // first element is min
                swap(key_arr[heap_arr[0].second], key_arr[heap_arr[n - 1].second]); // put last element to the first place
                swap(heap_arr[0], heap_arr[n - 1]);
                n--; // decrease quantity of elements in the array
                siftDown(0); // put element on the place 0 on the right position
            }
        }
    }
    return 0;
}