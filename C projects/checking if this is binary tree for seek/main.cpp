#include <iostream>
#include <fstream>

using namespace std;
/**
 * struct tree have ptr to left and right children and value
 */
struct tree{
    tree * left = nullptr;
    tree * right = nullptr;
    int value = 0;
};
/**
 * recursive function if we go to the left then remember value as max
 * if we go to the right then remember value as min
 * @return true if YES, false if NO
 */
bool check(tree* node, int minimum, int maximum){
    if(node == nullptr){
        return true;
    }
    if(node->value <= minimum || node->value >= maximum){
        return false;
    }
    return check(node->left, minimum, node->value) && check(node->right, node->value, maximum);
}

int main() {
    ifstream Fin;
    Fin.open("check.in");
    int N = 0;
    Fin >> N;
    ofstream Fout;
    Fout.open("check.out");
    if(N == 0){ // if we have tree with 0 roots then write 0
        Fout << "YES";
        return 0;
    }
    /**
     * create tree
     */
    tree** sakura = new tree* [N + 1];
    for (int i = 1; i <= N; i++){
        sakura[i] = new tree;
    }
    int value, left, right;
    /**
     * read from input file and write to the tree
     */
    for (int i = 1; i <= N; i++){
        Fin >> value >> left >> right;
        sakura[i]->value = value;

        if (left != 0){
            sakura[i]->left = sakura[left];
        }
        if (right != 0){
            sakura[i]->right = sakura[right];
        }
    }
    if (check(sakura[1], -1000000001, 1000000001)){
        Fout << "YES";
    }
    else{
        Fout << "NO";
    }

    return 0;
}