#include <iostream>
#include <vector>
#include <fstream>
#include <queue>

using namespace std;

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("pathbge1.in");
    Fout.open("pathbge1.out");

    queue <int> queue; // create queue
    queue.push(0);// push first point
    int n, m, x, y;
    Fin >> n >> m; // read from file quantity of ribs and points
    vector <bool> visited(n, false); // shows whether we visited point or not
    visited[0] = true; // remember that first point we visited (used to correct work of cycle)
    vector <int> distance(n, 0); // shows distance to all points and initially it's 0
    vector < vector<int> > graph(n); // create graph
    /**
     * read ribs from file
     * ribs are undirected so remember both directions
     */
    for(int i = 0; i < m; i++){
        Fin >> x >> y;
        graph[x - 1].push_back(y - 1);
        graph[y - 1].push_back(x - 1);
    }

    while(!queue.empty()){ // while queue is not empty
        int v = queue.front(); // remember current point
        queue.pop(); // pop it from queue
        for(int i = 0; i < graph[v].size(); i++){ // go through all connected points
            int u = graph[v][i]; // remember connected point
            if(!visited[u]){ // if point wasn't visited
                visited[u] = true; // remember that it's visited
                queue.push(u); // push it to queue
                distance[u] = distance[v] + 1; // distance to this point 1 more than to the previous one
            }
        }
    }
    /**
     * print answer
     */
    for(int i = 0; i < n; i++){
        Fout << distance[i] << " ";
    }
    Fin.close();
    Fout.close();
    return 0;
}