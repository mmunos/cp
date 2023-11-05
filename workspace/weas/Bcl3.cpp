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
    int vars[n][n-3];
    int vname = 1, tot = 0;
    for(int i = 0; i < n; i++){
        int a = 0, b = n-4;
        for(int d = n-2; d >= 2; d--, a++, b--){
            int j = (i + d) % n;
            // cerr << i << " " << j << endl;
            if(j > i){
                vars[i][a] = vname;
                vars[j][b] = vname; vname++; tot += 2;
            }
        }
    }
    cout << tot+2 << endl;
    cout << vname << " ";
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n-3; j++){
            cout << vars[i][j] << " ";
        }
    }
    cout << vname << " ";
    cout << endl;
}