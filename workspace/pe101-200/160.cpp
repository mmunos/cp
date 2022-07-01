#include <iostream>

using namespace std;

typedef long long int ll;

ll pow(ll x, ll y, ll mod){ //mod 100000
    ll res = 1, b = x;
    while(y > 0){
        if(y % 2 == 1){
            res *= b; res %= mod;
        }
        b *= b; b %= mod;
        y >>= 1;
    }
    return res;
}

int main(){
    ll x = 1000000000000L;
    int N = 100000;
    ll val[N+1];
    val[0] = 0;
    val[1] = 1;
    for(int i = 2; i <= N; i++){
        if(i % 2 != 0 and i % 5 != 0){
            val[i] = val[i-1] * i % N;
        }
        else{
            val[i] = val[i-1];
        }
    }
    cout << "yes" << endl;
    val[0] = val[N];
    // for(int i = 0; i < N; i++){
    //     cout << i << ": " << val[i] << endl;
    // }
    ll two = 1;
    ll res = 1;
    while(two <= x){
        ll twofive = two;
        while(twofive <= x){
            cout << twofive << ":" << endl;
            ll p = x / twofive;
            cout << "p: " << p << endl;
            ll a = pow(val[0], p / N, N);
            cout << "a: " << a << endl;
            ll b = val[p % N];
            cout << "b: " << b << endl;
            res *= a; res %= N;
            res *= b; res %= N;
            twofive *= 5;
        }
        two *= 2;
    }
    two = 1;
    ll ctwo = 0;
    while(two <= x){
        ctwo += x / two;
        two *= 2;
    }
    ll cfive = 0;
    ll five = 1;
    while(five <= x){
        cfive += x / five;
        five *= 5;
    }
    cout << res << endl;
    cout << ctwo << endl;
    cout << cfive << endl;
    ll off = pow(2, ctwo - cfive, N);
    res *= off; res %= NL_SETMAX;
    cout << res << endl;
}