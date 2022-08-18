#include <bits/stdc++.h>
using namespace std;

#define ll long long
// #define pq priority_queue <int, vector<int>, greater<int>>

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n, m;
        cin >> n >> m;
        vector<vector<int>> g(n);
        for(int i = 0; i < m; i++){
            int u, v;
            cin >> u >> v;
            u--; v--;
            g[u].push_back(v);
            g[v].push_back(u);
        }
        int col[n];
        for(int i = 0; i < n; i++){
            col[i] = 0;
        }
        queue<int> q;
        q.push(0);
        col[0] = 1;
        vector<int> sol;
        sol.push_back(0);
        while(!q.empty()){
            int u = q.front();
            q.pop();
            for(int v: g[u]){
                if(col[v] == 0){
                    col[v] = -col[u];
                    if(col[v] == 1) sol.push_back(v);
                    q.push(v);
                }
            }
        }
        bool cn = true;
        for(int i = 0; i < n; i++){
            if(col[i] == 0) cn = false;
        }
        if(!cn){
            cout << "NO\n";
        }
        else{
            cout << "YES\n";
            cout << sol.size() << '\n';
            for(int v: sol){
                cout << v+1 << " \n"[v == sol.back()];
            }
        }
    }
}