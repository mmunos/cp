#include <iostream>
#include <vector>
using namespace std;

typedef long long int ll;

int count(ll x){
    int res = 0;
    while(x > 0){
        if(x & 1) res++;
        x >>= 1;
    }
    return res;
}

int main(){
    int m = 12;
    ll arr[m];
    arr[0] = 6;
    for(int i = 1; i < m; i++){
        arr[i] = arr[i-1] * (i + 3);
    }
    // for(int i = 0; i < m; i++){
    //     cout << arr[i] << ' ';
    // }
    // cout << endl;
    int mm = 1 << m;
    ll vals[mm];
    for(int i = 0; i < mm; i++){
        vals[i] = 0;
        int aux = i;
        for(int j = 0; j < m; j++){
            if(aux & 1) vals[i] += arr[j];
            aux >>= 1;
        }
    }
    int T;
    cin >> T;
    while(T--){
        ll x;
        cin >> x;
        int res = 100;
        for(int i = 0; i < mm; i++){
            int a = count(i);
            if(vals[i] <= x){
                ll u = x - vals[i];
                int b = count(u);
                // cout << i << ' ' << a << ' ' << u << ' ' << b << endl;
                res = min(res, a + b);
            }
        }
        cout << res << endl;
    }

}