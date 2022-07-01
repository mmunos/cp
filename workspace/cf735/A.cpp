#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        ll arr[n];
        for (int i = 0; i < n; i++){
            cin >> arr[i];
        }
        ll res = 0;
        for(int i = 0; i < n-1; i++){
            ll v = arr[i] * arr[i+1];
            res = max(res, v);
        }
        cout << res << '\n';
    }
}