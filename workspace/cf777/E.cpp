#include <iostream>
using namespace std;

const int N = 100001;
int g[N];
int state[N];
int t = 0;
int ts[N];
int dist[N];
int dest[N];
int cycle[N];

void dfs(int u, int p){
    ts[u] = t++;
    state[u] = 1;  
    if(state[g[u]] == 1){
        cycle[u] = ts[u] - ts[g[u]];
        dest[u] = u;
        dist[u] = 0;
    }
    else{
        if(state[g[u]] == 0){
            dfs(g[u], u);
        }
    }


    state[u] = 2;
}

int main(){
    int n;
    for(int i = 0; i < n; i++){
        cin >> g[i];
        g[i]--;
        state[i] = 0;
    }
    for(int i = 0; i < n; i++){
        if(state[i] == 0){
            dfs(i, -1);
        }
    }
    int brr[n];
    int maxv = 0;
    for(int i = 0; i < n; i++){
        cin >> brr[i];

    }


}