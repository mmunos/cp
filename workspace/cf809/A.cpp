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
        int n, m;
        cin >> n >> m;
        string s;
        for(int i = 0; i < m; i++){
            s.push_back('B');
        }
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            int x = a, y = m+1-a;
            if(x > y) swap(x, y);
            if(s[x-1] == 'B') s[x-1] = 'A';
            else s[y-1] = 'A';
        }
        cout << s << '\n';
    }
}