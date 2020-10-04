#include <iostream>
#include <vector>
#include <fstream>

using namespace std;
/**
 * go though connected points, remember to which component it's connected and remember that we were at this point
 * if we didn't attend a neighbout then start dfs from there
 * @param u current point
 * @param graph - vector of vectors - shows connection between points
 * @param components - shows what component a point belongs to
 * @param visited - shows whether this point was visited or not
 * @param k - quantity of passed components
 */
void dfs(int u, vector < vector<int> > graph, vector <int>& components, vector<bool>& visited, int k){
    visited[u] = true; // show that we were on the point we're looking now
    components[u] = k; // remember the component this point belongs to
    for(int v = 0; v < graph[u].size(); v++){ // look at all points with which current point has connection
        if(!visited[graph[u][v]]){ // if we didn't visit the neighbour then go there
            dfs(graph[u][v], graph, components, visited, k);
        }
    }
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("components.in.txt");
    Fout.open("components.out.txt");

    int k = 0; // counter of passed components
    int n, m, x, y;
    Fin >> n >> m;
    vector < vector<int> > graph(n); // show connection between points
    vector <int> components(n, 0); // show to which component points belong to
    vector <bool> visited(n, false); // show whether we looked at the point
    /**
     * read ribs from file
     * fill table of connections of undirected graph so from x to y and from y to x
     */
    for(int i = 0; i < m; i++){
        Fin >> x >> y;
        graph[x - 1].push_back(y - 1);
        graph[y - 1].push_back(x - 1);
    }
    /**
     * look at all points and if wasn't there then start dfs
     */
    for(int i = 0; i < n; i++){
        if(!visited[i]){
            k++;
            dfs(i, graph, components, visited, k);
        }
    }
    /**
     * print answer
     */
    Fout << k << endl;
    for(int i = 0 ; i < components.size() ; i++){
        Fout << components[i] << " ";
    }

    Fin.close();
    Fout.close();
    return 0;
}