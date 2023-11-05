#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <set>
#include <map>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); 
    int T;
    cin >> T;
    cout << T << endl;
    while(T--){
        int m;
        cin >> m;
        int arr[m];
        map<int,vector<int>> pos;
        for(int i = 0; i < m; i++){
            cin >> arr[i];
            arr[i]--;
            pos[arr[i]].push_back(i);
        }
        set<pair<int,int>> graph;
        for(int i = 0; i < m-1; i++){
            graph.insert({i, i+1});
        }
        for(pair<int,vector<int>> p: pos){
            for(int i: pos[p.first]){
                graph.insert({i, p.first+m});
            }
        }
        cout << "p tw " << m + pos.size() << " " << graph.size() << '\n';
        for(auto e: graph){
            cout << e.first+1 << ' ' << e.second+1 << '\n';
        }
    }
}