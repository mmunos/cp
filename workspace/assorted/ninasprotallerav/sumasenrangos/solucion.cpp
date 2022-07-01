#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    int n;
    cin >> n;
    ll arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    ll acc[n];
    ll tot = 0;
    for(int i = 0; i < n; i++){
         tot += arr[i];
         acc[i] = tot;
    }
    int q;
    cin >> q;
    while(q--){
        int l, r;
        cin >> l >> r;
        if(l == 1){
            cout << acc[r-1] << '\n';
        }
        else{
            cout << acc[r-1] - acc[l-2] << '\n';
        }
    }
}