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
        int m;
        cin >> m;
        int arr[m];
        map<int,vector<int>> pos;
        for(int i = 0; i < m; i++){
            cin >> arr[i];
            arr[i]--;
            pos[arr[i]].push_back(i);
        }
        for(int i = 0; i < m; i++){
            cerr << arr[i] << ' ';
        }
        cerr << endl;
        for(pair<int,vector<int>> p: pos){
            cerr << p.first << ": ";
            for(int i: pos[p.first]){
                cerr << i << ' ';
            }
            cerr << endl;
        }
        cerr << endl;
        // for(int i = 0; i < n; i++){
        //     cerr << i << ": "; 
        //     for(int p: pos[i]){
        //         cerr << p << ' ';
        //     }
        //     cerr << endl;
        // }
        vector<int> threes, twos;
        bool goon = true;
        for(pair<int,vector<int>> p: pos){
            if(p.second.size() <= 1){
                cerr << "why\n";
            }
            if(p.second.size() == 2){
                twos.push_back(p.first);
            }
            if(p.second.size() == 3){
                threes.push_back(p.first);
            }
            if(p.second.size() > 3){
                goon = false; break;
            }
        }
        if(!goon){
            cerr << "more than 3 vars bye\n"; continue;
        }
        int N = 2;
        cout << N << endl;
        for(int mask = 0; mask < N; mask++){
            // vector<int> choices;
            set<pair<int,int>> graph;
            for(int i = 0; i < m-1; i++){
                graph.insert({i, i+1});
            }
            for(int i: twos){
                graph.insert({pos[i][0], pos[i][1]});
            }
            for(int i: threes){
                if(mask == 0){
                    graph.insert({pos[i][0], pos[i][1]});
                    graph.insert({pos[i][1], pos[i][2]});
                }
                // else ... {
                //     graph.insert({pos[i][0], pos[i][1]});
                //     graph.insert({pos[i][0], pos[i][2]});
                // }
                else{ 
                    graph.insert({pos[i][0], pos[i][1]});
                    graph.insert({pos[i][0], pos[i][2]});
                }
            }
            cout << "p tw " << m << " " << graph.size() << '\n';
            for(auto e: graph){
                cout << e.first + 1 << ' ' << e.second+1 << '\n';
            }
        }
    }
}