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
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int lastpos[n+1];
        int res[n+1];
        for(int i = 0; i <= n; i++){
            lastpos[i] = -1;
            res[i] = 0;
        }
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            if(lastpos[a] < 0){
                lastpos[a] = i;
                res[a]++;
            }
            else{
                if((i - lastpos[a]) % 2 == 1){
                    lastpos[a] = i;
                    res[a]++;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            cout << res[i];
            if(i == n) cout << '\n';
            else cout << ' ';
        }
    }
}