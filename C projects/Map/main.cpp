#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
#include <iomanip>

using namespace std;
/*
 * struct Node for List
 */
struct Node {
    string key, value;
    Node *next;
    Node *prev;
};

class List {
private:
    Node *root = nullptr;

public:
    /*
     * if key is in array then replace value of key to new value
     */
    bool replace(string key, string value) {
        Node *curNode = root;
        while (curNode != nullptr) {
            if (curNode->key == key) { // if we found element with key then replace its value
                curNode->value = value;
                return true;
            }
            curNode = curNode->next;
        }
        return false;
    }
    /*
     * create new Node with needed key and value
     */
    void push(string key, string value) {
        Node *newNode = new Node;
        newNode->key = key;
        newNode->value = value;
        newNode->next = newNode->prev = nullptr;
        if (root == nullptr) {
            root = newNode;
            return;
        }
        root->prev = newNode;
        newNode->next = root;

        root = newNode; // root points to the last element
    }
    /*
     * pop element from the List
     */
    void pop(string key) {
        Node *curNode = root;

        while (curNode != nullptr) {
            if (curNode->key == key) { // if we found element
                if (curNode->prev == nullptr && curNode->next == nullptr) { // if there are no others elements
                    root = nullptr;
                    return;
                }
                if (curNode->prev == nullptr) { // if element is the first
                    root->next->prev = nullptr;
                    root = root->next;
                    return;
                }
                if (curNode->next == nullptr) { // if element is the last
                    curNode->prev->next = nullptr;
                    return;
                }
                Node *newNode = curNode; // if element isn't at borders
                curNode->prev->next = newNode->next;
                curNode->next->prev = newNode->prev;
                return;
            }
            curNode = curNode->next;
        }
    }
    /*
     * get value of the element with needed key
     */
    string get(string key) {
        Node *curNode = root;
        while (curNode != nullptr) {
            if (curNode->key == key)
                return curNode->value;
            curNode = curNode->next;
        }
        return "none";
    }
};

class Map {
private:
    vector<List> list;
    vector<unsigned long long> serenity;

    int hashFunction(string s) {
        unsigned long long hash = 0;
        for (int i = 0; i < s.size(); i++)
            hash += (s[i] - 'a') * serenity[i];
        return hash % 10000;
    }

public:
    Map() {
        list.resize(10000);
        serenity.resize(20);
        serenity[0] = 1;
        for (int i = 1; i < 20; i++) {
            serenity[i] = serenity[i - 1] * 29;
        }
    }
    /*
     * if key element is in finction then replace it's value else push it to the List
     */
    void push(string key, string value) {
        if (list[hashFunction(key)].replace(key, value))
            return;
        list[hashFunction(key)].push(key, value);
    }
    /*
     * pop element with needed key
     */
    void pop(string key) {
        list[hashFunction(key)].pop(key);
    }
    /*
     * get value of element with key
     */
    string get(string key) {
        return list[hashFunction(key)].get(key);
    }
};

int main() {
    ifstream Fin("map.in");
    ofstream Fout("map.out");

    Map miniMap;
    string command;
    string key, value;

    while (Fin >> command >> key) {
        if (command == "put") { // if command put then push value to the List
            Fin >> value;
            miniMap.push(key, value);
        }

        if (command == "delete") // if command delete then pop element from List
            miniMap.pop(key);

        if (command == "get") // if command get then get value with needed key
            Fout << miniMap.get(key) << endl;
    }
    return 0;
}