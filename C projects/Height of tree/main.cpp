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
 * recursive function if we have child then use function again
 * @return count max length from point to bottom and + 1
 */
int height(tree* root) {
    int left = 0, right = 0;
    if(root->left != nullptr){
        left = height(root->left);
    }
    if(root->right != nullptr){
        right = height(root->right);
    }
    return (max(left, right) + 1);
}

int main() {
    ifstream Fin;
    Fin.open("height.in");
    int N = 0;
    Fin >> N;
    ofstream Fout;
    Fout.open("height.out");
    if(N == 0){ // if we have tree with 0 roots then write 0
        Fout << 0;
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
    Fout << height(sakura[1]);

    return 0;
}