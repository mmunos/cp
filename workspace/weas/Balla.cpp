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
        N++;
    } while(next_permutation(arr, arr+m));
    cout << N << endl;
}