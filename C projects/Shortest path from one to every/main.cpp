#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

const long long MAX = 8000000000000000000;

struct rib{
    rib(int f, int t, long long w) : from(f), to(t), weight(w){};
    int from;
    int to;
    int weight;
};

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("pathbgep.in"); // open input file
    Fout.open("pathbgep.out"); // open output file

    int n, m, from, to, weight;
    Fin >> n >> m;
    vector <rib> graph; // ribs of graph
    vector <long long> distance; // distance to point
    distance.resize(n, MAX); // resize distance and fill with MAX
    distance[0] = 0; // distance to the first point is 0


    for(int i = 0; i < m; i++){ // read ribs from file and push to graph
        Fin >> from >> to >> weight;
        graph.push_back(rib(from - 1, to - 1, weight));
    }

    bool changed;
    for (int i = 0; ; i++){
        changed = false;
        for (int j = 0; j < graph.size(); j++){ // relax ribs, two if because graph is unorientated
            if (distance[graph[j].to] > distance[graph[j].from] + graph[j].weight){
                distance[graph[j].to] = distance[graph[j].from] + graph[j].weight;
                changed = true;
            }
            if (distance[graph[j].from] > distance[graph[j].to] + graph[j].weight){
                distance[graph[j].from] = distance[graph[j].to] + graph[j].weight;
                changed = true;
            }
        }
        if (!changed){
            break;
        }
    }

    for (int i = 0; i < n; i++){ // print answer
        Fout << distance[i] << " ";
    }

    Fin.close();
    Fout.close();
    return 0;
}