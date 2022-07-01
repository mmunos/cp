#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long
ll mod = 998244353;

int sum(int a, int b) {
	long res = a;
	res = (res + b) % mod;
	return (int)res;
}

int main(){
    int n;
    cin >> n;
    ll arr[n];
    for (int i = 0; i < n; i++){
        string s;
        cin >> s;
        if(s[0] == '+'){
            cin >> arr[i];
        }
        else{
            arr[i] = -1;
        }
    }
    long res = 0;
    int dp[n+1][n];
    for(int ind = 0; ind < n; ind++) {
        if(arr[ind] > 0) {
            for(int i = 0; i <= n; i++) {
                for(int j = 0; j < n; j++){
                    dp[i][j] = 0;
                }
            }
            dp[0][0] = 1;
            for(int i = 0; i < ind; i++) {
                for(int j = 0; j < n; j++) {
                    dp[i+1][j] = sum(dp[i+1][j], dp[i][j]); 
                    if(arr[i] == -1) {
                        if(j > 0) {
                            dp[i+1][j-1] = sum(dp[i+1][j-1], dp[i][j]);
                        }
                        else {
                            dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                        }
                    }
                    else if(arr[i] <= arr[ind]) {
                        if(j < n-1) {
                            dp[i+1][j+1] = sum(dp[i+1][j+1], dp[i][j]);
                        }
                    }
                    else { //if(arr[i] > arr[ind])
                        dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                dp[ind+1][j] = dp[ind][j];
            }
            for(int i = ind+1; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dp[i+1][j] = sum(dp[i+1][j], dp[i][j]); 
                    if(arr[i] == -1) {
                        if(j > 0) {
                            dp[i+1][j-1] = sum(dp[i+1][j-1], dp[i][j]);
                        }
                        else {
                            //dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                        }
                    }
                    else if(arr[i] < arr[ind]) {
                        if(j < n-1) {
                            dp[i+1][j+1] = sum(dp[i+1][j+1], dp[i][j]);
                        }
                    }
                    else { //if(arr[i] > arr[ind])
                        dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                    }
                }
            }
            int curr = 0;
            for(int j = 0; j < n; j++) {
                curr = sum(curr, dp[n][j]);
            }
            res += curr * arr[ind] % mod; res %= mod;
        }
    }
    cout << res << endl;
}