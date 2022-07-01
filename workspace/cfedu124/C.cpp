#include <iostream>
using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        ll arr[n], brr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        for(int i = 0; i < n; i++){
            cin >> brr[i];
        }
        ll x = 1e15, y = 1e15, z = 1e15, w = 1e15;
        for(int i = 0; i < n; i++){
            x = min(x, abs(arr[0] - brr[i]));
            y = min(y, abs(arr[n-1] - brr[i]));
            z = min(z, abs(brr[0] - arr[i]));
            w = min(w, abs(brr[n-1] - arr[i]));
        }
        ll _ll = abs(arr[0] - brr[0]);
        ll _lr = abs(arr[0] - brr[n-1]);
        ll _rl = abs(arr[n-1] - brr[0]);
        ll _rr = abs(arr[n-1] - brr[n-1]);
        ll res = 1e15;
        
        // circle
        ll a = _ll + _rr;
        res = min(res, a);
        // bowtie
        ll b = _lr + _rl;
        res = min(res, b);
        // left left
        ll c = _ll + y + w;
        res = min(res, c);
        // left right
        ll d = _lr + y + z;
        res = min(res, d);
        // right left;
        ll e = _rl + x + w;
        res = min(res, e);
        // right right
        ll f = _rr + x + z;
        res = min(res, f);
        // none
        ll g = x + y + w + z;
        res = min(res, g);

        cout << res << endl;

    }

}