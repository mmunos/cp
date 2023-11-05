#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <set>
#include <map>
#include <random>
#include <chrono>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

int main(){
    int N = 0;
    int n = 3, k = 4;
    int m = n * k;
    int arr[m];
    for(int i = 0; i < m; i++){
        arr[i] = i/k+1;
    }
    do{
        //check if unique
        set<int> vals;
        bool yes = true;
        for(int i = 0; i < m; i++){
            if(arr[i]-1 > vals.size()) {yes = false; break;}
            vals.insert(arr[i]);
        }
        if(!yes) continue;
        cout << m << endl;
        for(int i = 0; i < m; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
        N++;
    } while(next_permutation(arr, arr+m));
    cout << N << endl;
}