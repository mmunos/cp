#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int K = 9;
    int T;
    cin >> T;
    while(T--){
        int n; //n = 100
        cin >> n;
        ll arr[n];
        ll a = 1;
        ll x = 0;
        for(int i = 0; i < K; i++){
            arr[i] = a;
            x += arr[i];
            a *= 2;
        }
        a /= 2; a++;
        vector<ll> brr;
        for(int i = K; i < n; i++){
            arr[i] = a;
            brr.push_back(a);
            a++;
        }
        for(int i = 0; i < n-1; i++){
            cout << arr[i] << ' ';
        }
        cout << arr[n-1] << '\n';

        for(int i = 0; i < n; i++){
            ll b;
            cin >> b;
            brr.push_back(b);
        }
        ll tot = 0;
        for(ll b: brr) tot += b;

        // cout << "tot: " << tot << '\n';

        vector<ll> sol;
        ll y = 0;
        for(int i = 0; i < brr.size(); i++){
            sol.push_back(brr[i]);
            y += brr[i];
            if(abs((tot - y) - y) < x) break;
        }
        ll form = -1;
        if(y >= tot - y){
            form = (x - (y - (tot - y)))/2;
        }
        else{
            form = x - (x - ((tot - y) - y))/2;
        }
        for(int i = 0; i < K; i++){
            if(form & (1 << i)){
                sol.push_back(1 << i);
            }
        }
        cout << sol[0];
        for(int i = 1; i < sol.size(); i++){
            cout << ' ' << sol[i];
        }
        cout << '\n';
    }
}