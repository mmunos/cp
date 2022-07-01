#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, k;
        cin >> n >> k;
        ll arr[n];
        for (int i = 0; i < n; i++){
            cin >> arr[i];
        }
        ll res = -1000000000;
        for(int i = 0; i < 201; i++){
            for(int j = 1; j <= 200; j++){
                int p = n-i-1;
                int q = p-j;
                if(p >= 0 && q >= 0){
                    ll v = (p+1);
                    v *= (q+1);
                    v -= (arr[p] | arr[q]) * k;
                    res = max(res, v);
                }
            }
        }
        cout << res << '\n';
    }
}