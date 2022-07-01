#include <iostream>
#include <algorithm>
#include <queue>
// #include <map>
#include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>


using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, k;
        cin >> n >> k;
        int arr[n];
        set<int> vals;
        for(int i = 0; i < n; i++){
            cin >> arr[i]; 
            vals.insert(arr[i]);
        }
        // calcular mex maximo
        int mex = 0;
        int kk = 0;
        for(int x: vals){
            if(x == mex){
                mex++;
            }
            else{
                while(x > mex){
                    kk++;
                    if(kk >= k) break;
                    mex++;
                }
            }
        }
        // armar una solucion con los numeros mas grandes que el mex
        // puede que el mex quede mas chico, el resultado es el mismo
        unordered_map<int, int> count;
        for(int i = 0; i < n; i++){
            if(arr[i] > mex){
                count[arr[i]]++;
            }
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<int>> q;
        for (auto& it: count) {
            q.push(make_pair(it.second, it.first));
        }
        int mex2 = 0;
        while(!q.empty()){
            pair<int, int> p = q.top(); q.pop();

        }
    }
}
