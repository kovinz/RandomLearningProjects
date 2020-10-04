#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

const long long MAX_LONGLONG = 9223372036854775807; // max number which can be in long long

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("pathmgep.in"); // open input file
    Fout.open("pathmgep.out"); // open output file

    int N, weight, S, F;
    Fin >> N >> S >> F; // read number of points, start and finish
    vector < pair<int , int> > graph[N]; // create graph of size N
    long long dist[N]; // massive to show distance to every element
    bool used[N]; // massive to show whether we used the element

    for(int i = 0; i < N; i++){
        dist[i] = MAX_LONGLONG; // initial distance to every point is maximum
        used[i] = false; // we didn't check ant point
        for(int j = 0; j < N; j++){ // read weight of rib and if it exists push to graph
            Fin >> weight;
            if(weight != -1){
                graph[i].push_back(make_pair(j, weight));
            }
        }
    }

    dist[S - 1] = 0; // distance to start point is 0
    for(int i = 0; i < N; i++){

        int v = -1;
        for(int j = 0; j < N; j++){ // find point with the smallest distance
            if(!used[j] && (v == -1 || dist[j] < dist[v])){
                v = j;
            }
        }

        if(dist[v] == MAX_LONGLONG){ // if smallest distance is maximum of longlong then break cycle
            break;
        }

        used[v] = true; // remember that we were on this point
        /**
         * check all connected points and if distance from current point + len
         * is smaller than distance that was written then remember the new one
         */
        for(int j = 0; j < graph[v].size(); j++){
            int to = graph[v][j].first;
            int len = graph[v][j].second;
            if(dist[v] + len < dist[to]){
                dist[to] = dist[v] + len;
            }
        }
    }

    if (dist[F - 1] == MAX_LONGLONG){ // if we didn't reach the finish point write -1 else write distance
        Fout << -1;
    }
    else{
        Fout << dist[F - 1];
    }

    Fin.close();
    Fout.close();
    return 0;
}