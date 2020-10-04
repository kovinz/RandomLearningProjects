#include <iostream>
#include <fstream>
#include <vector>
#include <stack>

using namespace std;

const long long MAX_LONGLONG = 9223372036854775807;

struct rib{
    int from; // from which point rib is
    int to; // to what point rib is
    long long weight; // weigth of rib
    rib(int f, int t, long long w) : from(f), to(t), weight(w){}
};

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("negcycle.in"); // open input file
    Fout.open("negcycle.out"); // open output file

    int currentPoint;
    long long weight;
    vector <long long> distance; // distance from one point to another
    vector <int> parent; // parent of point
    vector <rib> graph; // graph which shows ribs

    int n;
    Fin >> n; // read quantity of points
    distance.resize(n + 1, MAX_LONGLONG); // fill distances with maximum
    parent.resize(n + 1, -1); // fill parents with -1 (because there is no such point)

    for(int i = 0; i < n; i++){
        graph.push_back(rib(n, i, 0)); // push first rib
        for(int j = 0; j < n; j++){
            Fin >> weight; // read weight
            graph.push_back(rib(i, j, weight));
        }
    }
    distance[n] = 0;
    // algorithm of Bellman-Ford
    for(int i = 0; i <= n; i++){ // go through all points
        currentPoint = -1;
        for(int j = 0; j < graph.size(); j++){ // go through all ribs
            if(distance[graph[j].to] > distance[graph[j].from] + graph[j].weight){ // if we found path shorter then relax rib
                distance[graph[j].to] = distance[graph[j].from] + graph[j].weight;
                parent[graph[j].to] = graph[j].from; // remember to massive of parents
                currentPoint = graph[j].to; // remember relaxed point
            }
        }
    }

    if(currentPoint != -1){ // if we relaxed rib on the last cycle then we have cycle
        int cycle = currentPoint; // remember point
        for(int i = 0 ; i < n + 1 ; i++){ // go to the beginning of cycle with negative weight
            cycle = parent[cycle];
        }

        stack <int> result;
        for(int current = cycle; ;current = parent[current]){
            if(current != n){
                result.push(current); // push points of path of negative weight
            }
            if(current == cycle && result.size() > 1){ // if we came to the start of cycle then break
                break;
            }
        }
        //print answer
        Fout << "YES" << endl;
        Fout << result.size() << endl;
        while(!result.empty()){
            Fout << result.top() + 1 << " ";
            result.pop();
        }
    }
    else{ // if we didn't relaxed rib on the last cycle then we don't have cycle
        Fout << "NO";
    }

    Fin.close();
    Fout.close();
    return 0;
}