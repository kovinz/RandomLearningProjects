#include <iostream>
#include <fstream>
#include <stack>
#include <string>
using namespace std;

int main(){

    ifstream Fin; // open input file
    Fin.open("postfix.in");

    stack <int> stack; // create stack
    char postfix; // variable to read from file
    int previous_top; // remember previous top element

    while(Fin >> postfix){ // while we didn't reach the end of file
        switch(postfix){
            /*
             * if we meet * + or - then remember top element, pop it and * + or - with previous one
             */
            case '*':
                previous_top = stack.top();
                stack.pop();
                stack.top() *= previous_top;
                break;
            case '+':
                previous_top = stack.top();
                stack.pop();
                stack.top() += previous_top;
                break;
            case '-':
                previous_top = stack.top();
                stack.pop();
                stack.top() -= previous_top;
                break;
            default:
                stack.push(postfix - '0'); // just push numbers to stack

        }
    }

    ofstream Fout; // open output file
    Fout.open("postfix.out");
    Fout << stack.top(); // the last number in stack is the answer

    Fin.close(); // close files
    Fout.close();
    return 0;
}