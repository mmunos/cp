#include <iostream>
// #include <algorithm>
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
        int n, x;
        cin >> n >> x;
        ll arr[n];
        ll mina = 1000000000, maxa = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            mina = min(mina, arr[i]);
            maxa = max(maxa, arr[i]);
        }
        ll tot = 0;
        for(int i = 1; i < n; i++){
            tot += abs(arr[i-1] - arr[i]);
        }
        if(mina <= 1 and maxa >= x){
            cout << tot << '\n';
        }
        else if(maxa >= x){ //1 < mina
            ll add = abs(1 - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - 1) + abs(1 - arr[i]);
                add = min(add, curr - prev);
            }
            ll fincurr = abs(arr[n-1] - 1);
            add = min(add, fincurr);
            cout << tot + add << '\n';
        }
        else if(1 >= mina){ // x > maxa
            ll add = abs(x - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - x) + abs(x - arr[i]);
                add = min(add, curr - prev);
            }
            ll fincurr = abs(arr[n-1] - x);
            add = min(add, fincurr);
            cout << tot + add << '\n';
        }
        else{
            ll add1 = abs(1 - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - 1) + abs(1 - arr[i]);
                add1 = min(add1, curr - prev);
            }
            ll fincurr1 = abs(arr[n-1] - 1);
            add1 = min(add1, fincurr1);
            ll add2 = abs(x - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - x) + abs(x - arr[i]);
                add2 = min(add2, curr - prev);
            }
            ll fincurr2 = abs(arr[n-1] - x);
            add2 = min(add2, fincurr2);
            ll add3 = abs(1 - x) + abs(x - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - 1) + abs(1 - x) + abs(x - arr[i]);
                add3 = min(add3, curr - prev);
            }
            ll fincurr3 = abs(arr[n-1] - 1) + abs(1 - x);
            add3 = min(add3, fincurr3);
            ll add4 = abs(x - 1) + abs(1 - arr[0]);
            for(int i = 1; i < n; i++){
                ll prev = abs(arr[i-1] - arr[i]);
                ll curr = abs(arr[i-1] - x) + abs(x - 1) + abs(1 - arr[i]);
                add4 = min(add4, curr - prev);
            }
            ll fincurr4 = abs(arr[n-1] - x) + abs(x - 1);
            add4 = min(add4, fincurr4);
            ll add = min(min(add1 + add2, add3), add4);
            cout << tot + add << '\n';
        }
    }


}