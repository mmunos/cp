#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <bitset>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long
#define INF 1e9

const int N = 500010;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        int eqs = 0;
        set<int> s;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            if(s.count(arr[i])) eqs++;
            s.insert(arr[i]);
        }   
        while(n > 1){
            set<int> nexts;
            int last = -1;
            int nexteqs = 0;
            n = 0;
            for(int x: s){
                if(last >= 0){
                    if(nexts.count(x - last)) nexteqs++;
                    if(x - last > 0) n++;
                    nexts.insert(x - last);
                }
                last = x;
                // cout << i << ' ';
            }
            if(eqs > 0){
                nexts.insert(0);
                nexteqs += eqs-1;
            }
            eqs = nexteqs;
            // cout << endl;
            s.clear();
            for(int x: nexts) {
                s.insert(x);
            }
        }
        // cout << "heyo" << endl;
        int res = 0;
        for(int x: s){
            res = x;
        }
        cout << res << '\n';
    }
}