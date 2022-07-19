#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <vector>
#include <map>
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
    int n;
    while(cin >> n){
        if(n == 0) break;
        string t, v;
        int inc = 0, e = 0;
        map<string, string> m;
        for(int i = 0; i < n; i++){
            cin >> t >> v;
            if(v[0] == 'E') e++;
            else if(v[0] == 'X') e--;
            else inc++;
            m[t] = v;
        }
        int newe = (inc-e)/2;
        int curr = 0, maxcurr = 0;
        for(auto p: m){
            if(p.second[0] == 'E'){
                maxcurr = max(maxcurr, ++curr);
            }
            else if(p.second[0] == 'X'){
                curr--;
            }
            else{
                if(newe > 0){
                    newe--;
                    maxcurr = max(maxcurr, ++curr);
                }
                else{
                    curr--;
                }
            }
        }
        cout << maxcurr << '\n';
    }
}