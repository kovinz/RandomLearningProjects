#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
/**
 * count prefixFunction for string
 * @param s string of which to find + char + string where find
 * @return vector of prefix
 */
vector<int> prefixFunction(string s) {
    vector<int> pref(s.size(), 0); // create vector of size string p+t+1 and fill it with 0

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
    Fin.open("search2.in"); // open input file
    Fout.open("search2.out"); // open output file

    string p, t;
    Fin >> p >> t; // read p - string to find, t - string where find

    vector<int> result;
    if (p.size() <= t.size()) { // if size of string to find is shorter than size of string where find then it's fine
        vector <int> pref = prefixFunction(p + '~' + t); // count prefix function
        // if number in massive which we've got from prefix function == size of string to find then remember the position
        for (int i = 0; i < t.size(); i++){
            if (pref[p.size() + i + 1] == p.size()) {
                result.push_back(i - p.size() + 2);
            }
        }
    }

    Fout << result.size() << endl; // print answer
    for (int i = 0; i < result.size(); i++) {
        Fout << result[i] << ' ';
    }

    Fin.close();
    Fout.close();
}