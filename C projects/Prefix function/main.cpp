#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
/**
 * count prefix function
 * @param s string to count prefix function
 * @return vector with the result of prefix function
 */
vector<int> prefixFunction(string s) {
    vector<int> pref(s.size(), 0); // create vector of size of string and fill it with 0

    for (int i = 1; i < s.size(); i++) {
        int k = pref[i - 1];
        while (k > 0 && s[i] != s[k]) {
            k = pref[k - 1];
        }
        if (s[i] == s[k]) {
            k++;
        }
        pref[i] = k;
    }
    return pref;
}


int main() {
    ifstream Fin;
    ofstream Fout;
    Fin.open("prefix.in"); // open input file
    Fout.open("prefix.out"); // open output file

    string s;
    Fin >> s; // read string from input

    vector<int> result;
    result = prefixFunction(s); // count prefix function

    for (int i = 0; i < result.size(); i++){ // print answer
        Fout << result[i] << ' ';
    }

    return 0;
}