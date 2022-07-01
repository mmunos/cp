#include <iostream>
#include <algorithm>
#include <queue>
// #include <map>
#include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

const ll mod = 1000000007;
const int N = 400010;
ll facarr[N];
ll invfacarr[N];
static pair<ll, ll> gcdex(ll a, ll b){
	if(b > a) {
		pair<ll, ll> p = gcdex(b, a);
		return make_pair(p.second, p.first);
	}
	else if(b == 0) return make_pair(1, 0);
	else{
		pair<ll, ll> p = gcdex(b, a % b);
		return make_pair (p.second, p.first - p.second*(a/b));
	}
}
static ll inv(ll a){
	return (gcdex(a, mod).first + mod) % mod;
}
ll fac(int n){
	if(n == 0) return facarr[0] = 1;
	else if(facarr[n] > 0) return facarr[n];
	else return facarr[n] = n * fac(n-1) % mod;
}
static ll invfac(int n){
	if(invfacarr[n] > 0) return invfacarr[n];
	else return invfacarr[n] = inv(facarr[n]);
}
static ll choose(int n, int k){
	return fac(n) * invfac(k) % mod * invfac(n-k) % mod;
}
int main(){
    for(int i = 0; i < N; i++){
        facarr[i] = 0;
        invfacarr[i] = 0;
    }
    int n;
    cin >> n;
    ll res = 0;
    for(int i = 0; i <= n; i++){
        int a;
        cin >> a;
        ll x = choose(a+i, i+1);
        // cout << x << endl;
        res += x;
        res %= mod;
    }
    cout << res << '\n';

}