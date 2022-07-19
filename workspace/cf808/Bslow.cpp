#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <bitset>
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

const int N = 500010;
int c1[N];
int c2[N];

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    for(int i = 0; i < N; i++){
        c1[i] = 0;
        c2[i] = 0;
    }
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i]; 
            c1[arr[i]]++;
        }   
        int m = arr[n-1];
        while(n > 1){
            int last = -1;
            for(int i = 0; i <= m; i++){
                if(c1[i] > 0){
                    if(last >= 0){
                        c2[i - last]++;
                    }
                    c2[0] += c1[i]-1;
                    last = i;
                    // cout << i << ' ';
                }
            }
            // cout << endl;
            n = 0;
            for(int i = 1; i <= m; i++){
                n += c2[i];
            }
            for(int i = 0; i <= m; i++){
                c1[i] = c2[i];
                c2[i] = 0;
            }
        }
        // cout << "heyo" << endl;
        int res = 0;
        for(int i = 0; i <= m; i++){
            if(c1[i] > 0) res = i;
        }
        cout << res << '\n';
        for(int i = 0; i <= m; i++){
            c1[i] = 0;
        }
    }
}