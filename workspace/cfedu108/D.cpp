#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

int main(){
    int n;
    cin >> n;
    ll a[n], b[n];
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    for (int i = 0; i < n; i++){
        cin >> b[i];
    }
    ll tot = 0;
    for (int i = 0; i < n; i++){
        tot += a[i] * b[i];
    }
    ll res = 0;
    for (int p = 0; p < n; p++){
        int i = 0;
        ll curr = tot;
        while(p + i < n && p - i >= 0){
            curr -= a[p-i] * b[p-i];
            curr -= a[p+i] * b[p+i];
            curr += a[p-i] * b[p+i];
            curr += a[p+i] * b[p-i];
            // cout << p-i << " " << p+i << " " << curr << "\n";
            res = max(res, curr);
            i++;
        }
    }
    for (int p = 0; p < n; p++){
        int i = 0;
        ll curr = tot;
        while(p + i + 1 < n && p - i >= 0){
            curr -= a[p-i] * b[p-i];
            curr -= a[p+i+1] * b[p+i+1];
            curr += a[p-i] * b[p+i+1];
            curr += a[p+1+i] * b[p-i];
            // cout << p-i << " " << p+i+1 << " " << curr << "\n";
            res = max(res, curr);
            i++;
        }
    }
    cout << res << '\n';
}