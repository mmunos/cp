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
ll mod = 998244353;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int arr[n], brr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        for(int i = 0; i < n; i++){
            cin >> brr[i];
        }
        ll dp[n][2];
        dp[0][0] = 0; dp[0][1] = 0;
        for(int i = 1; i < n; i++){
            //no swap
            ll x = dp[i-1][0] + abs(arr[i-1] - arr[i]) + abs(brr[i-1] - brr[i]);
            ll y = dp[i-1][1] + abs(brr[i-1] - arr[i]) + abs(arr[i-1] - brr[i]);
            // cerr << x << ' ' << y << endl;
            dp[i][0] = min(x, y);
            //swap
            ll z = dp[i-1][0] + abs(brr[i-1] - arr[i]) + abs(arr[i-1] - brr[i]);
            ll w = dp[i-1][1] + abs(arr[i-1] - arr[i]) + abs(brr[i-1] - brr[i]);
            // cerr << z << ' ' << w << endl;
            dp[i][1] = min(z, w);
        }
        cout << min(dp[n-1][0], dp[n-1][1]) << '\n';
    }

}