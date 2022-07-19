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

const int N = 100001;

int arr[N], ks[N], val[N];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    auto cmp = [](int left, int right) { 
        if(val[left] == val[right]){
            return ks[left] < ks[right];
        }
        else{
            return val[left] < val[right];
        }
    };
    while(T--){
        int n, k;
        cin >> n >> k;
        std::priority_queue<int, std::vector<int>, decltype(cmp)> q(cmp);
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            ks[i] = 1;
            val[i] = arr[i];
            q.push(i);
        }
        int minv = arr[0];
        int res = INT32_MAX;
        while(!q.empty()){
            int p = q.top();
            res = min(res, val[p] - minv);
            if(val[p] <= 0) break;
            q.pop();
            if(ks[p] < k){
                if(ks[p] < 320) ks[p]++;
                else{
                    ks[p] = arr[p] / (arr[p] / ks[p] - 1);
                    // cout << p.second << endl;
                }
                val[p] = arr[p] / ks[p];
                if(val[p] < minv) minv = val[p];
                q.push(p);
            }
            else{
                break;
            }
        }
        cout << res << '\n';
        
    }
}
