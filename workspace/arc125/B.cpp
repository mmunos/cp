#include <iostream>
#include <math.h>

typedef long long ll;

using namespace std;
ll mod = 998244353;

int main(){
    ll n;
    cin >> n;
    ll sqn = sqrt(n);
    ll res = 0;
    ll lastcurr = 0;
    ll lasta = n;
    for(ll t = 1; t <= sqn; t++){ //a*a + y = x*x
        ll a = (n - t*t)/(2*t);
        ll toadd = (lasta - a) % mod * (t-1) % mod;
        res = (res + toadd) % mod;
        lasta = a;
    }
    ll toadd = sqn * (lasta + 1) % mod;
    res = (res + toadd) % mod;
    std::cout << res << endl;
}