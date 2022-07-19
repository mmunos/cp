#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
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
        set<int> s;
        for(int i = 0; i < n; i++){
            int x;
            cin >> x;
            if(x == 1) s.insert(i);
        }
        if(s.empty()){
            cout << (n+1)/2 << '\n';
        }
        else{
            int res = 0;
            auto it = s.begin();
            while(it != s.end()){
                int a = *it++;
                int b;
                if(it == s.end()){
                    b = *s.begin() + n;
                }
                else{
                    b = *it;
                }
                // cout << "a: " << a << " b: " << b << " = " << (b-a-1)/2 << endl;
                res += (b-a-1)/2;
            }
            cout << res << '\n';
        }
    }
}