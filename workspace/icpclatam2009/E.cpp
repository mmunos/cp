#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <vector>
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

ll calc(ll x){
    ll tot = 0;
    tot += 2*min(x,    100ll); x -= 100; if(x <= 0) return tot;
    tot += 3*min(x,   9900ll); x -= 9900; if(x <= 0) return tot;
    tot += 5*min(x, 990000ll); x -= 990000; if (x <= 0) return tot;
    tot += 7*x;
    return tot;
}
ll decalc(ll tot){
    ll x = 0;
    if(tot < 100 * 2) return tot/2;
    x += 100; tot -= 100 * 2;
    if(tot < 9900 * 3) return x + tot/3;
    x += 9900; tot -= 9900 * 3;
    if(tot < 990000 * 5) return x + tot/5;
    x += 990000; tot -= 990000 * 5;
    return x + tot/7;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    ll a, b;
    while(cin >> a >> b){
        if(a == 0 and b == 0) break;
        ll x = decalc(a);
        // cout << "x: " << x << endl;
        int lo = 0, hi = x/2;
        while(hi - lo > 1){
            int mid = (lo + hi)/2;
            if(calc(x - mid) - calc(mid) > b) lo = mid;
            else hi = mid;
        }
        cout << calc(hi) << '\n';
    }
}