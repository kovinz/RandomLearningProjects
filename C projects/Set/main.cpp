#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
/*
 * hash function
 */
int hassh(int value){
    return (value >= 0 ? value : -value) % 1000;
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("set.in");
    Fout.open("set.out");
    vector <int> set[1000];
    string command;
    int value;
    bool exists;
    while(Fin >> command){
        Fin >> value;
        if(command == "insert"){
            exists = false;
            for(int i = 0; i < set[hassh(value)].size(); i++){ // go through vector if we didn't find value then insert
                if(set[hassh(value)][i] == value){ // if we found needed element then break for
                    exists = true;
                    break;
                }
            }
            if(!exists){ // if didn't value push back
                set[hassh(value)].push_back(value);
            }
        }
        if(command == "exists"){
            exists = false;
            for(int i = 0; i < set[hassh(value)].size(); i++){ // go through vector if we found element print "true"
                if(set[hassh(value)][i] == value){ // if we found element then break for and print "true"
                    exists = true;
                    break;
                }
            }
            Fout << (exists ? "true" : "false") << endl;
        }
        if(command == "delete"){
            for(int i = 0; i < set[hassh(value)].size(); i++){ // go through vector if we found value then erase it
                if(set[hassh(value)][i] == value){
                    set[hassh(value)].erase(set[hassh(value)].begin() + i);
                    break;
                }
            }
        }
    }
    Fin.close();
    Fout.close();
    return 0;
}