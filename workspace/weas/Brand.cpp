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
    mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
    ios_base::sync_with_stdio(false); cin.tie(NULL); 
    int N = 10000;
    int n = 4, k = 4;
    int m = n * k;
    int arr[m];
    for(int i = 0; i < m; i++){
        arr[i] = i/k+1;
    }
    cout << N << endl;
    srand(time(NULL));
    while(N--){
        int m = k*n;
        int arr[m];
        for(int i = 0; i < m; i++){
            arr[i] = i % n + 1;
        } 
        shuffle(arr, arr + m, rng);
        cout << m << endl;
        for(int i = 0; i < m; i++){
            cout << arr[i] << ' ';
        }
        cout << endl;
    }
}