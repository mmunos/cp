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
        int k, n;
        cin >> k >> n;
        int m = k * n;
        int arr[m];
        for(int i = 0; i < m; i++){
            char c;
            cin >> c;
            arr[i] = c - 'a';
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
        cout << N << endl;
        for(int mask = 0; mask <= N; mask++){
            // vector<int> choices;
            set<pair<int,int>> graph;
            for(int i = 0; i < m-1; i++){
                graph.insert({i, i+1});
            }
            int aux = mask;
            for(int i = 0; i < n; i++){
                int ch = aux % k; aux /= k;
                // choices.push_back(aux % k); 
                if(ch == 0){
                    graph.insert({pos[i][0], pos[i][1]});
                    graph.insert({pos[i][1], pos[i][2]});
                }
                else if(ch == 1){
                    graph.insert({pos[i][0], pos[i][1]});
                    graph.insert({pos[i][0], pos[i][2]});
                }
                else{ //ch = 2
                    graph.insert({pos[i][0], pos[i][2]});
                    graph.insert({pos[i][1], pos[i][2]});
                }
            }
            cout << "p tw " << m << " " << graph.size() << '\n';
            for(auto e: graph){
                cout << e.first + 1 << ' ' << e.second+1 << '\n';
            }
        }
    }   
}