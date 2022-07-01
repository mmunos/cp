#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;

    while(T--){
        int n; ll x;
        cin >> n >> x;
        ll arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        sort(arr, arr+n);
        ll tot = 0;
        ll ind = n;
        for(int i = 0; i < n; i++){
            tot += arr[i];
            if(tot > x){
                ind = i; break;
            }
        }
        if(ind < n) tot -= arr[ind];
        ll res = 0;
        ll prevb = 0;
        while(ind > 0){
            ll a = -1, b = 1000000000;
            while(b - a > 1){
                ll c = (a + b)/2;
                // cout << a << ' ' << b << ' ' << c << endl;
                // cout << c * ind << endl;
                // cout << tot + c * ind << ' ' << x << endl;
                if(tot + c * ind > x) b = c;
                else a = c;
            }
            // cout << a << ' ' << b << endl;
            res += (b - prevb) * ind;
            prevb = b;
            ind--;
            if(ind >= 0) tot -= arr[ind];
        }
        cout << res << '\n';
    }


}