#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        ll n, m;
        cin >> n >> m;
        // cout << m << ' ' << n << endl;
        set<ll> res;
        res.insert(1LL);
        res.insert(2LL);
        for(ll k = 1; k*k <= n; k++){
            if((n-1) % k == 0){ //spiral
                if((m-1) % k == 0){
                    res.insert(k);
                }
                ll kk = (n-1) / k;
                if((m-1) % kk == 0){
                    res.insert(kk);
                }
            }
            if((n-2) % k == 0){ //wall
                if(m % k == 0){
                    res.insert(k);
                }
                ll kk = (n-2) / k;
                if(m % kk == 0){
                    res.insert(kk);
                }
            }
            if(n % k == 0){ //hat
                if((m-2) % k == 0){
                    res.insert(k);
                }
                ll kk = n / k;
                if((m-2) % kk == 0){
                    res.insert(kk);
                }
            }
        }
        int count = res.size();
        cout << count;
        for(ll x: res){
            cout << ' ' << x;
        }
        cout << '\n';
    }

}