#include <iostream>
#include <algorithm>
// #include <deque>
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
    int caso = 1;
    while(T--){
        int n, m;
        cin >> n >> m;
        ll arr[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin >> arr[i][j];
            }
            sort(arr[i], arr[i] + m);
        }
        ll dp[n][2]; //0 asc 1 desc
        dp[0][0] = arr[0][m-1];
        dp[0][1] = arr[0][m-1] + abs(arr[0][m-1] - arr[0][0]);
        for(int i = 1; i < n; i++){
            ll aa = abs(arr[i][0] - arr[i-1][m-1]);
            ll ab = abs(arr[i][m-1] - arr[i-1][m-1]);
            ll ba = abs(arr[i][0] - arr[i-1][0]);
            ll bb = abs(arr[i][m-1] - arr[i-1][0]);
            ll d = abs(arr[i][m-1] - arr[i][0]);
            dp[i][0] = min(dp[i-1][0] + aa + d, dp[i-1][1] + ba + d);
            dp[i][1] = min(dp[i-1][0] + ab + d, dp[i-1][1] + bb + d);
        }
        ll res = min(dp[n-1][0], dp[n-1][1]);
        cout << "Case #" << caso++ << ": " << res << '\n';
    }


}