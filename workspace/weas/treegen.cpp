#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <map>
#include <bit>
#include <bitset>
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
    int n;
    cin >> n;
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
    int counttot = 0;
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
            counttot++;
            cout << "p tw " << n << " " << n-1 << '\n';
            for(int i = 0; i < N; i++){
                if(mask & (1 << i)){
                    int u = es[i].first, v = es[i].second;
                    cout << u+1 << " " << v+1 << '\n';
                }
            }
        }
    }
    cout << counttot << '\n';
}