#include <iostream>
#include <fstream>
#include <vector>
#include <queue>

using namespace std;

const long long MAX = 8000000000000000000;

struct rib{
    int from; // from what point the rib is
    int to; // to what point the rib is
    long long weight; // weight of rib
    rib(int f , int t , long long w) : from(f), to(t), weight(w){}
};

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("path.in"); // open input file
    Fout.open("path.out"); // open output file

    int n, m, s, from, to;
    long long weight;
    vector < vector<int> > matrix; // matrix of adjacent points
    vector <long long> distance; // distance to point
    vector <bool> check; // for checking
    vector <rib> graph; // ribs of graph

    Fin >> n >> m >> s; // read quantity of points, ribs and point to start
    matrix.resize(n); // resize matrix of adjacent points
    distance.resize(n, MAX); // resize distance and fill with MAX
    check.resize(n, false); // resize checking and fill with false

    for(int i = 0; i < m; i++){ // read ribs from file and push to two vectors
        Fin >> from >> to >> weight;
        graph.push_back(rib(from - 1, to - 1, weight));
        matrix[from - 1].push_back(to - 1);
    }
    // algorithm of Ford-Bellman
    distance[s - 1] = 0; // distance to the first point is 0
    queue <int> cycle;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < graph.size(); j++){
            if(distance[graph[j].to] > distance[graph[j].from] + graph[j].weight && distance[graph[j].from] < MAX){ // if we can relax
                distance[graph[j].to] = max(-MAX , distance[graph[j].from] + graph[j].weight);
                if(i == n - 1 || distance[graph[j].to] < -MAX){ // if no shortest way
                    cycle.push(graph[j].to);
                }
            }
        }
    }

    while(!cycle.empty()){
        from = cycle.front();
        cycle.pop();
        check[from] = true; // means that there's no shortest way
        for(int i = 0; i < matrix[from].size(); i++){ // remember cycle
            if(!check[matrix[from][i]]){ // if didn't pointed
                cycle.push(matrix[from][i]); // push points of cycle
            }
        }
    }

    for(int i = 0; i < n; i++){
        if(check[i] || distance[i] < -MAX){ // if we found cycle with negative path print no shortest path
            Fout << '-' << endl;
            continue;
        }
        if(distance[i] == MAX){ // if distance == max it means that we didn't reach the point
            Fout << '*' << endl;
            continue;
        }
        Fout << distance[i] << endl; // else print distance to point
    }

    Fin.close();
    Fout.close();

    return 0;
}