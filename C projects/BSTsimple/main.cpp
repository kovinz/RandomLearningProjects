#include <iostream>
#include <fstream>

using namespace std;
/**
 * struct contains pointer to left and right children, to parent and a key
 */
struct Node{
    int key;
    Node *left = NULL;
    Node *right = NULL;
    Node *parent = NULL;
};

class Binary_Tree{
private:
    Node *root;
public:
    Binary_Tree(){
        root = NULL;
    }
    void * set_root(Node *x);
    Node * get_root();
    Node * minimum(Node *x);
    Node * maximum(Node *x);
    Node * next(int x);
    Node * prev(int x);
    Node * exists(int x);
    Node * element_insert(Node *x , int z);
    Node * element_delete(Node *x , int z);
    void tree_delete(Node *leaf);
    ~Binary_Tree(){
        tree_delete(root);
    }
};

Node * Binary_Tree:: get_root(){
    return this -> root;
}

void * Binary_Tree:: set_root(Node *x){
    this -> root = x;
}
/**
 * go to the left border
 * @return minimum
 */
Node * Binary_Tree:: minimum(Node *x){
    return x -> left ? minimum(x -> left) : x;
}
/**
 * go to the right border
 * @return maximum
 */
Node * Binary_Tree:: maximum(Node *x){
    return x -> right ? maximum(x -> right) : x;
}
/**
 * @param x - find minimum element which is bigger than x
 * @return leaf next to x
 */
Node * Binary_Tree:: next(int x){
    Node *current = this -> root , *successor = NULL;
    /**
     * while we didn't reach the last leaf
     * if key > x then go to the left and remember every element because the last one will be next
     * else we go to the right and then check again
     */
    while(current != NULL){
        if(current -> key > x){
            successor = current;
            current = current -> left;
        }
        else{
            current = current -> right;
        }
    }
    return successor;
}
/**
 * @param x - find maximum element which is smaller than x
 * @return leaf prev to x
 */
Node * Binary_Tree:: prev(int x){
    Node *current = this -> root , *successor = NULL;
    /**
     * while we didn't reach the last leaf
     * if key < x then go to the right and remember every element because the last one will be prev
     * else we go to the left and then check again
     */
    while(current != NULL)
    {
        if(current -> key < x)
        {
            successor = current;
            current = current -> right;
        }
        else{
            current = current -> left;
        }
    }
    return successor;
}
/**
 * check whether element x exists is BST
 * @param x element to check
 * @return where x is, if there is no x then we go to the border and return NULL
 */
Node * Binary_Tree:: exists(int x){
    Node *current = this -> root;
    /**
     * while we didn't find the element: if key > x go to left else go to right
     */
    while(current != NULL && current -> key != x)
    {
        current = current -> key > x ? current -> left : current -> right;
    }
    return current;
}
/**
 * finds the needed place to insert element
 * @param x where to start seeking for place
 * @param z element to insert
 * @return where the element is inderted
 */
Node * Binary_Tree:: element_insert(Node *x , int z){
    if(x == NULL){ // if we found NULL then insert element there
        x = new Node;
        x -> parent = NULL;
        x -> left = NULL;
        x -> right = NULL;
        x -> key = z;
        return x;
    }
    else{ // if we didn't reach NULL then if z < key go to left else go to right
        if(z < x -> key){
            x -> left = element_insert(x -> left , z);
        }
        if(z > x -> key){
            x -> right = element_insert(x -> right , z);
        }
    }
    return x;
}
/**
 * finds where key is and when found, delete it and shifts elements if ti's needed
 * @param x where to start seeking
 * @param z what to delete
 * @return pointer to the same Node
 */
Node * Binary_Tree:: element_delete(Node *x , int z){
    if(x == NULL){
        return x;
    }
    if(z < x -> key){ // if z < key go to the left else go to the right
        x -> left = element_delete(x -> left , z);
    }
    else
        if(z > x -> key){
            x -> right = element_delete(x -> right , z);
        }
            /**
             * if we found where element is:
             * 1) if it has 2 children:
             * print next to the key by finding minimum of the right child (do it for all children)
             * 2) if it has 1 children:
             * print children to the place where parent was
             * 3) if it has 0 children:
             * delete element
             */
        else{
            if(x -> left != NULL && x -> right != NULL){
                x -> key = minimum(x -> right) -> key;
                x -> right = element_delete(x -> right , x -> key);
            }
            else{
                if(x -> left != NULL){
                    x = x -> left;
                }
                else{
                    x = x -> right;
            }
        }
    }
    return x;
}
/**
 * free memory
 * @param leaf Node to start recursively deleting elements
 */
void Binary_Tree:: tree_delete(Node *leaf){
    if(leaf != NULL){
        tree_delete(leaf -> left);
        tree_delete(leaf -> right);
        delete leaf;
    }
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("bstsimple.in");
    Fout.open("bstsimple.out");
    Binary_Tree A;
    string operation;
    int value;
    Node *result = new Node;
    while(Fin >> operation){
        Fin >> value;
        /**
         * read a given command, call needed function
         */
        if(operation == "insert"){
            A.set_root(A.element_insert(A.get_root() , value));
        }
        if(operation == "delete"){
            A.set_root(A.element_delete(A.get_root() , value));
        }
        if(operation == "next"){
            result = A.next(value);
            if(result == NULL){
                Fout << "none" << endl;
            }
            else{
                Fout << result -> key << endl;
            }
        }
        if(operation == "prev"){
            result = A.prev(value);
            if(result == NULL){
                Fout << "none" << endl;
            }
            else{
                Fout << result -> key << endl;
            }
        }
        if(operation == "exists"){
            result = A.exists(value);
            Fout << (result ? "true" : "false") << endl;
        }
    }
    Fin.close();
    Fout.close();
    return 0;
}