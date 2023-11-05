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
    int k = 3, n = 4;
    int m = k*n;
    int rep = 100;
    ll seed = time(NULL);
    while(rep--){
        int arr[m];
        for(int i = 0; i < m; i++){
            arr[i] = i % n;
        } 
        srand(seed); seed = random();
        random_shuffle(arr, arr + m);
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
        set<pair<int,int>> graph;
        for(int i = 0; i < m-1; i++){
            graph.insert({i, i+1});
        }
        for(int i = 0; i < n; i++){
            graph.insert({pos[i][0], pos[i][1]});
            graph.insert({pos[i][1], pos[i][2]});
        }
        cout << "f([";
        bool flag = false;
        for(pair<int,int> e: graph){
            if(flag) cout << ", ";
            flag = true;
            cout << "(" << e.first << ", " << e.second << ")";
        }
        cout << "]), ";
    }
}