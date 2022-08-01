// #pragma GCC optimize("Ofast")
// #pragma GCC target("bmi,bmi2,lzcnt,popcnt")
// #pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
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
#define pq priority_queue <int, vector<int>, greater<int>>

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, g;
    while(cin >> n >> g){
        ll res = 0;
        int ties = 0;
        pq q;
        for(int i = 0; i < n; i++){
            int x, y;
            cin >> x >> y;
            if(x > y) res += 3;
            else if(x == y){
                res++; ties++;
            }
            else{
                q.push(y - x);
            }
        }
        while(g > 0){
            if(ties > 0){
                res += 2; ties--; g--;
            }
            else{
                if(!q.empty() and q.top() <= g){
                    g -= q.top(); q.pop(); res++; ties++;
                }
                else break;
            }
        }
        cout << res << '\n';
    }
}