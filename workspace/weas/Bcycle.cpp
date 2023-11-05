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
    while(T--){
        int k, n; //k = multiplicity of each variable, n = number of variable names
        cin >> k >> n;
        int m = k * n;
        int arr[m];
        for(int i = 0; i < m; i++){
            cin >> arr[i];
            arr[i]--;
        }
        for(int i = 0; i < m; i++){
            cerr << arr[i] << ' ';
        }
        cerr << endl;
        vector<int> pos[n];
        for(int i = 0; i < m; i++){
            pos[arr[i]].push_back(i);
        }
        // for(int i = 0; i < n; i++){
        //     cerr << i << ": "; 
        //     for(int p: pos[i]){
        //         cerr << p << ' ';
        //     }
        //     cerr << endl;
        // }
        int N = 1;
        for(int iter = 0; iter < n; iter++){
            N *= k;
        }
        cout << 1 << endl;
        set<pair<int,int>> graph;
        for(int i = 0; i < m-1; i++){
            graph.insert({i, i+1});
        }
        for(int i = 0; i < n; i++){
            graph.insert({pos[i][0], pos[i][1]});
            graph.insert({pos[i][1], pos[i][2]});
            graph.insert({pos[i][0], pos[i][2]});
        }
        cout << "p tw " << m << " " << graph.size() << '\n';
        for(auto e: graph){
            cout << e.first + 1 << ' ' << e.second+1 << '\n';
        }
    }
}