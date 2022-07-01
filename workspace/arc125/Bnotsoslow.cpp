#include <iostream>
#include <math.h>

typedef __int128 ll;

using namespace std;
ll mod = 998244353;

ll bigsqrt(ll a, ll n){//sqrt(a*a+n
    ll rlo = 0, rhi = a+n;
    while(rhi - rlo > 1){
        ll r = (rlo + rhi)/2;
        if(r*r <= a * a + n) rlo = r;
        else rhi = r;
    }
    return rlo;
}

void print(ll a, ll val){
    long long aout = a;
    long long valout = val;
    std::cout << aout << " " << valout << endl;
}

int main(){
    long long inn;
    cin >> inn;
    cout << inn << endl;
    ll n = inn;
    ll sqn = sqrt(n);
    ll res = 0;
    ll lastcurr = 0;
    for(ll a = 0; a <= n; a++){ //a*a + y = x*x
        ll curr = bigsqrt(a, n);
        lastcurr = curr - a;
        print(a, curr - a);
        res = (res + curr - a) % mod;
    }
    long long outres = res;
    cout << outres << endl;
}