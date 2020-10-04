#include <iostream>
#include <vector>
#include <stack>
#include <fstream>

using namespace std;
/**
 * watch connected points of current point,
 * if we haven't seen the point (white) remember it in path and start dfs for it
 * if we met cycle remember start and end
 * @param v current point
 * @param color of points
 * @param graph table of ribs
 * @param stack to write an answer
 * @param cycle shows whether we have cycle in our graph
 * @param path shows path in cycle
 * @param start of cycle
 * @param end of cycle
 */
void dfs(int v, vector <int>& color, vector < vector<int> >& graph, bool& cycle, vector <int>& path, int& start, int& end){
    color[v] = 1; // color of current point - gray
    for(int i = 0; i < graph[v].size(); i++){ // check all connected points
        if(color[graph[v][i]] == 1){ // if color of connected point is gray - we found cycle
            cycle = true;
            start = graph[v][i];
            end = v;
            return;
        }
        if(color[graph[v][i]] == 0){ // if color of connected point is gray - start dfs for it
            path[graph[v][i]] = v;
            dfs(graph[v][i], color, graph, cycle, path, start, end);
            if (cycle){
                return;;
            }
        }
    }
    color[v] = 2; // color of current point - black
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("cycle.in");
    Fout.open("cycle.out");

    int n , m, start, end;
    Fin >> n >> m; // read quantity of points and ribs from file
    bool cycle = false; // shows whether we have a cycle
    vector < vector<int> > graph(n); // graph shows connection between points
    vector <int> color(n, 0); // 0 - white, 1 - gray, 2 - black
    vector <int> path(n, 0);
    /**
     * read ribs from file
     */
    int from, to;
    for(int i = 0; i < m; i++){
        Fin >> from >> to;
        graph[from - 1].push_back(to - 1);
    }
    /**
     * go through all points in graph
     */
    for(int i = 0; i < n; i++){
        if(cycle){
            break;
        }
        if(color[i] == 0){ // if color is white and we didn't meet cycle
            path.clear();
            dfs(i, color, graph, cycle, path, start, end);
        }
    }

    if(cycle){ // if we found cycle
        Fout << "YES" << endl;
        vector <int> pathOfCycle; // create vector to remember answer
        for(int i = end; i != start; i = path[i]){ // go from one end to another and push points to vector
            pathOfCycle.push_back(i);
        }
        pathOfCycle.push_back(start); // push last point
        for(int i = pathOfCycle.size() - 1 ; i >= 0 ; i--){ // we know size of cycle then print vector with answer
            Fout << pathOfCycle[i] + 1 << " ";
        }
    }
    else{ // if we didn't met cycle print NO
        Fout << "NO";
    }

    Fin.close();
    Fout.close();
    return 0;
}