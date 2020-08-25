#include <iostream>
using namespace std;

#define ll long long

int main(){
    int t;
    cin >> t;
    while(t--){
        ll p, f, a, b, s, w;
        cin >> p >> f >> a >> b >> s >> w;
        if(s > w){
            swap(w,s); swap(a,b);
        }
        ll res = 0;
        for(ll i = 0; i < a; i++){
            //You carry i of the smallest thing
            ll s1 = max(i, p/s);
            ll s2 = max(a - i, f/s);
            ll w1 = max((p - s1*s)/w, b);
            ll w2 = max((p - s1*s)/w, b - w1);
            res = max(res, s1 + s2 + w1 + w2);
        }
        cout << res << "\n";
    }
}