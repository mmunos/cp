#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>
// #include <chrono>
// #include <random>

using namespace std;

typedef long long int ll;

vector<int> g2[5001];
vector<int> g[5001];

int dp[5001][10000];
int arr[5001];

int pr[10001];

void dfs(int u, int p){
    for(int v: g[u]){
        if(v == p) continue;
        dfs(v, u);
    }
    for(int i = 0; i < 10000; i++){
        dp[u][i] = 10000;
    }
    for(int x = 2; x <= 10000; x++){
        int aux = x;
        vector<int> ps;
        while(aux > 1){
            ps.push_back(pr[aux]);
            aux /= pr[aux];
        }
        int val = x;
        if(arr[u] == x) val = 0;
        for(int v: g[u]){
            if(v == p) continue;
            int chval = 10000;
            for(int p: ps){
                chval = min(chval, dp[v][p]);
            }
            val += chval;
        }
        for(int p: ps){
            dp[u][p] = min(dp[u][p], val);
        }
    }

    // cout << u << endl;
    // for(int i = 1; i < 10; i++){
    //     cout << dp[u][i] << ' ';
    // }
    // cout << endl;
}


int main(){
    int N = 10000;
    for(int i = 0; i <= N; i++){
        pr[i] = -1;
    }
    for(int i = 2; i <= N; i++){
        if(pr[i] < 0){
            pr[i] = i;
            for(int j = i*i; j <= N; j += i){
                pr[j] = i;
            }
        }
    }
    // for(int i = 0; i < 100; i++){
    //     cout << pr[i] << ' ';
    // }
    // cout << endl;
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    for(int i = 0; i < n-1; i++){
        int u, v;
        cin >> u >> v;
        u--; v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    dfs(0, -1);
    int res = 10000;
    for(int i = 2; i <= 10000; i++){
        res = min(res, dp[0][i]);
    }
    cout << res << '\n';
}