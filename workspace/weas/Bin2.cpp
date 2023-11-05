#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <bit>
#include <bitset>
#include <map>
#include <iomanip>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

struct DSU {
    vector<int> p, rank; 
    DSU(int N) {
        for(int i = 0; i < N; i++){
            p.push_back(i);
            rank.push_back(0);
        }
    }
    int find(int x) {
        if(p[x] != x){
            return p[x] = find(p[x]);
        }
        else return x;
    }
    void unite(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) swap(x,y);
        p[y] = x;
        if(rank[x] == rank[y]) rank[x]++;
    }
};

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); 
    int maxn = 5;
    vector<vector<pair<int,int>>> g[maxn+1];
    for(int n = 2; n <= maxn; n++){
        //canonical
        vector<pair<int,int>> gcan;
        for(int i = 0; i < n-1; i++){
            gcan.push_back({i,i+1});
        }
        g[n].push_back(gcan);
        vector<pair<int,int>> es;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                es.push_back({i,j});
            }
        }
        int N = es.size();
        int arr[N];
        for(int i = 0; i < N; i++){
            arr[i] = i;
        }
        // int counttot = 0;
        for(uint32_t mask = 0; mask < (1 << N); mask++){
            if(__popcount(mask) != n-1) continue;
            DSU uf(n);
            bool valid = true;
            for(int i = 0; i < N; i++){
                if(mask & (1 << i)){
                    int u = es[i].first, v = es[i].second;
                    if(uf.find(u) == uf.find(v)){
                        valid = false; break;
                    }
                    uf.unite(u, v);
                }
            }
            if(valid){
                vector<pair<int,int>> gr;
                for(int i = 0; i < N; i++){
                    if(mask & (1 << i)){
                        gr.push_back(es[i]);
                    }
                }
                if(gr != gcan) g[n].push_back(gr);
            }
        }
        // cerr << "trees of size " << n << ": " << g[n].size() << endl;
    }
    int m;
    cin >> m;
    int arr[m];
    map<int,vector<int>> vpos;
    for(int i = 0; i < m; i++){
        cin >> arr[i];
        arr[i]--;
        vpos[arr[i]].push_back(i);
    }
    int N = 1;
    for(pair<int,vector<int>> p: vpos){
        N *= g[p.second.size()].size();
    }  
    cout << N << '\n';
    for(int mask = 0; mask < N; mask++){
        set<pair<int,int>> es;
        for(int i = 0; i < m-1; i++){
            es.insert({i, i+1});
        }
        int aux = mask;
        for(pair<int,vector<int>> p: vpos){
            vector<int> pos = p.second;
            int nn = g[p.second.size()].size();
            int ch = aux % nn; aux /= nn;
            for(pair<int,int> e: g[pos.size()][ch]){
                es.insert({pos[e.first], pos[e.second]});
            }
        }
        cout << "p tw " << m << " " << es.size() << '\n';
        for(auto e: es){
            cout << e.first + 1 << ' ' << e.second+1 << '\n';
        }
    }
}