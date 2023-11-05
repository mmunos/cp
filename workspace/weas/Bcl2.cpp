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
    ios_base::sync_with_stdio(false); cin.tie(NULL); 
    int n;
    cin >> n; //k >= 4
    deque<int> vars[n];
    int vname = 1, totvars = 0;
    int i = 0, j = n-1;
    for(; j-i >= 3; i++, j--){
        vars[i].push_back(vname);
        vars[j].push_front(vname); vname++; totvars += 2;
        for(int k = i+2; k <= j-2; k++){
            vars[i].push_back(vname);
            vars[k].push_back(vname);
            vars[j].push_front(vname); vname++; totvars += 3;
        }
        vars[i].push_back(vname);
        vars[j-1].push_front(vname); vname++; totvars += 2;
        vars[i+1].push_back(vname);
        vars[j].push_front(vname); vname++; totvars += 2;
    }
    vars[i].push_back(vname);
    vars[j].push_front(vname); vname++; totvars += 2;
    for(int i = 0; i < n; i++){
        for(int v: vars[i]){
            cerr << v << " ";
        }
        cerr << endl;
    }
    cout << totvars << endl;
    for(int i = 0; i < n; i++){
        for(int v: vars[i]){
            cout << v << " ";
        }
    }
    cout << endl;
}