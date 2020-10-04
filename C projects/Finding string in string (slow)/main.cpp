#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

vector<int> naiveSearch(string p, string t) {
    vector <int> result; // create vector to remember the answer
    for (int i = 0; i < t.size() - p.size() + 1; i++) { // go through the string
        bool flag = true;
        int current = i;
        for (int j = 0; j < p.size(); j++) { // check whether part of string t = string p
            if (t[current] != p[j]) { // if we found that != then break
                flag = 0;
                break;
            }
            current++;
        }
        if (flag) // if flag stayed raised then push position i + 1 to answer
            result.push_back(i + 1);
    }
    return result; // return vector with positions where p = part of t
}

int main() {
    ifstream Fin;
    ofstream Fout;
    Fin.open("search1.in"); // open input file
    Fout.open("search1.out"); // open output file

    string p, t;
    Fin >> p >> t; // read p - string to find, t - string where find

    vector<int> result; // create vector to remember the answer
    if (p.size() <= t.size()) { // if string to find shorter than string where find then it's fine
        result = naiveSearch(p, t); // do algorithm and remember it to vector
    }

    Fout << result.size() << endl; // print answer
    for (int i = 0; i < result.size(); i++)
        Fout << result[i] << ' ';

}