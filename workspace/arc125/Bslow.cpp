#include <iostream>
#include <math.h>

typedef long long ll;

using namespace std;
ll mod = 998244353;

int main(){
    ll n;
    cin >> n;
    ll res = 0;
    for(ll x = 1; x <= n; x++){
        for(ll y = 1; y <= n; y++){
            ll val = x*x - y;
            ll sqval = sqrt(val);
            if(sqval * sqval == val) res++;
        }
    }
    cout << res;
}