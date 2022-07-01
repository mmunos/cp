#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

typedef long long int ll;

int dr(int x){
    int r = x % 9;
    if(r == 0) return 9;
    else return r;
}

int main(){
    int n = 1000000;
    int dp[n+1];
    dp[1] = 1;
    ll sum = 0;
    for(int i = 2; i < n; i++){
        dp[i] = dr(i);
        for(int d = 2; d*d <= i; d++){
            if(i % d == 0){
                int v1 = dr(d) + dp[i/d];
                dp[i] = max(dp[i], v1);
                int v2 = dr(i/d) + dp[d];
                dp[i] = max(dp[i], v2);
            }
        }
        cout << i << ": " << dp[i] << endl;
        sum += dp[i];
    }
    cout << sum;
}