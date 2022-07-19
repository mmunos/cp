#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long
#define INF 1e9

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        if(n % 2 == 1){
            ll res = 0;
            for(int i = 1; i < n-1; i++){
                if(i % 2 == 1){
                    int x = max(arr[i-1], arr[i+1]);
                    res += max(0, x+1-arr[i]);
                }
            }
            cout << res << '\n';
        }   
        else{
            ll resl[n][2], resr[n][2];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < 2; j++){
                    resl[i][j] = 0; resr[i][j] = 0;
                }
            }
            for(int i = 1; i < n-1; i++){
                resl[i][0] = resl[i-1][0];
                resl[i][1] = resl[i-1][1];
                int x = max(arr[i-1], arr[i+1]);
                resl[i][i%2] += max(0, x+1-arr[i]);
            }
            for(int i = n-2; i >= 1; i--){
                resr[i][0] = resr[i+1][0];
                resr[i][1] = resr[i+1][1];
                int x = max(arr[i-1], arr[i+1]);
                resr[i][i%2] += max(0, x+1-arr[i]);
            }
            // for(int i = 0; i < n; i++){
            //     cout << resl[i][0] << ' ';
            // }
            // cout << endl;
            // for(int i = 0; i < n; i++){
            //     cout << resl[i][1] << ' ';
            // }
            // cout << endl;
            // for(int i = 0; i < n; i++){
            //     cout << resr[i][0] << ' ';
            // }
            // cout << endl;
            // for(int i = 0; i < n; i++){
            //     cout << resr[i][1] << ' ';
            // }
            // cout << endl;

            ll res = LLONG_MAX;
            for(int i = 0; i < n-1; i += 2){
                ll curr = resl[i][1] + resr[i+1][0];
                res = min(res, curr);
            }
            cout << res << '\n';
        }
    }
}