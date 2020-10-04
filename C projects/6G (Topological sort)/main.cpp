#include <iostream>
#include <vector>
#include <stack>
#include <fstream>

using namespace std;
/**
 * watch connected points of current point,
 * if we haven't seen the point (white) start dfs for it,
 * add current point to stack
 * check for cycle
 * @param v current point
 * @param color of points
 * @param graph table of ribs
 * @param stack to write an answer
 * @param cycle shows whether we have cycle in our graph
 */
void dfs(int v, vector <int>& color, vector < vector<int> >& graph, stack <int>& stack, bool& cycle){
    color[v] = 1; // color of current point - gray
    for(int i = 0; i < graph[v].size(); i++){ // check all connected points
        if(color[graph[v][i]] == 1){ // if color of connected point is gray - we found cycle
            cycle = true;
        }
        if(color[graph[v][i]] == 0){ // if color of connected point is gray - start dfs for it
            dfs(graph[v][i], color, graph, stack, cycle);
        }
    }
    stack.push(v); // push current point to stack
    color[v] = 2; // color of current point - black
}

int main(){
    ifstream Fin;
    ofstream Fout;
    Fin.open("topsort.in");
    Fout.open("topsort.out");

    int n , m;
    Fin >> n >> m; // read quantity of points and ribs from file
    bool cycle = false; // shows whether we have a cycle
    vector < vector<int> > graph(n); // graph shows connection between points
    vector <int> color(n, 0); // 0 - white, 1 - gray, 2 - black
    stack <int> stack; // stack to write result
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
        if(color[i] == 0){ // if color is white
            dfs(i, color, graph, stack, cycle);
        } // if we found cycle print -1
        if(cycle){
            Fout << -1;
            Fin.close();
            Fout.close();
            return 0;
        }
    }

    if(!cycle){ // if we haven't found cycle print answer
        while(!stack.empty()){
            Fout << stack.top() + 1 << " ";
            stack.pop();
        }
    }
    else{
        Fout << -1;
    }

    Fin.close();
    Fout.close();
    return 0;
}