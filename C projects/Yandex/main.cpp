#include <iostream>

using namespace std;

int main() {

    short int n = 0;

    cin >> n;

    int * a = new int [n];
    int * b = new int [n];
    double * p = new double [n];
    double full = 0;

    for (int i = 0; i < n; i++){
        cin >> a[i] >> b[i];
    }

    for (int i = 0; i < n; i++){
        p[i] = (a[i]/100.0)*(b[i]/100.0);
        full +=p[i];
    }

    cout << fixed;
    cout.precision(12);
    for (int i = 0; i < n; i++){
        cout << p[i]/full << endl;
    }
    return 0;
}