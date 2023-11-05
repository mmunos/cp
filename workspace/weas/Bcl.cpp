#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <deque>
#include <set>
#include <map>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

int main(){


    int k = 20;// 10100
                //00001
                //00010
                //00100
                //01000
                //10000
    int n = 4;
    for(int mask = 0; mask < (1 << n); mask++){
        for(int i = 0; i < n; i++){
            if(mask & (1 << i)){
                cout << i <<  " yes ";
            }
            else{
                cout << i << " no ";
            }
        }
        cout << endl;
    }

    for(int i = 0; i < 5; i++){
    }

    // ios_base::sync_with_stdio(false); cin.tie(NULL); 
    // int k;
    // cin >> k; //k >= 4
    // deque<int> vars[k];
    // int vname = 1;
    // for(int i = 2; i <= k-3; i++){
    //     vars[0].push_front(vname);
    //     vars[i].push_back(vname);
    //     vars[k-1].push_front(vname); vname++;
    // }
    // vars[0].push_front(vname);
    // vars[k-2].push_back(vname); vname++;
    // vars[1].push_back(vname);
    // vars[k-1].push_back(vname); vname++;
    // vars[0].push_front(vname);
    // vars[k-1].push_back(vname); vname++;
    // for(int d = k-3; d >= 2; d--){
    //     for(int i = 1; i+d <= k-2; i++){
    //         vars[i].push_back(vname);
    //         vars[i+d].push_front(vname); vname++;
    //     }
    // }
    // cout << 2*(vname-1) + k-4 << endl;
    // for(int i = 0; i < k; i++){
    //     for(int v: vars[i]){
    //         cout << v << " ";
    //     }
    // }
    // cout << endl;
}