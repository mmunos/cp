#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>
#include <functional>

using namespace std;

#define ll long long
#define INF 1e9

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    auto cmp = [](pair<int, int> left, pair<int, int> right) { 
        if(left.first / left.second == right.first / right.second){
            return left.second < right.second;
        }
        else{
            return left.first / left.second < right.first / right.second;
        }
    };
    while(T--){
        int n, k;
        cin >> n >> k;
        int arr[n];
        std::priority_queue<pair<int, int>, std::vector<pair<int, int>>, decltype(cmp)> q(cmp);
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            q.push(make_pair(arr[i], 1));
        }
        int minv = arr[0];
        int res = INT32_MAX;
        while(!q.empty()){
            pair<int, int> p = q.top();
            res = min(res, p.first / p.second - minv);
            q.pop();
            if(p.second < k){
                p.second++;
                int val = p.first / p.second;
                if(val < minv) minv = val;
                q.push(p);
            }
            else{
                break;
            }
        }
        cout << res << '\n';
        
    }
}