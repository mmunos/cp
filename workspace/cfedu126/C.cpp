#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;
ll mod = 998244353;
    
#define N 32768

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        int maxa = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            maxa = max(maxa, arr[i]);
        }  
        ll ones = 0, twos = 0;
        ll tot = 0;
        for(int i = 0; i < n; i++){
            int d = maxa - arr[i];
            tot += d;
            twos += d / 2;
            if(d % 2 == 1) ones++;
        }
        if(ones > twos){
            ll res = ones * 2 - 1;
            cout << res << '\n';
        }
        else{
            if(tot % 3 == 0){
                cout << tot/3*2 << '\n';
            }
            else if(tot % 3 == 1){
                cout << tot/3*2 + 1 << '\n';
            }
            else{
                cout << tot/3*2 + 2 << '\n';
            }
        }
    }
}