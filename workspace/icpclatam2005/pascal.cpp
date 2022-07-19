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
// #include <functional>

using namespace std;

#define ll long long

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, m;
    while(cin >> m >> n){
        if(n == 0 and m == 0) break;
        int c[m];
        for(int i = 0; i < m; i++){
            c[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int x;
                cin >> x;
                c[j] += x;
            }
        }
        bool yes = false;
        for(int i = 0; i < m; i++){
            if(c[i] == n) yes = true;
        }
        if(yes) cout << "yes\n";
        else cout << "no\n";
    }
}