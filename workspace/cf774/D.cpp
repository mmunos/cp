#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

typedef long long int ll;

const int N = 200001;
vector<int> g[N];
int dp[N][2][2];
unordered_set<int> gch[N];

void dfs(int u, int p){
    int c = 0;
    for(int v: g[u]){
        if(v == p) continue;
        c++;
        dfs(v, u);
    }
    if(c == 0){
        dp[u][0][0] = 1; //total goods if u is good
        dp[u][0][1] = 1; //total cost if u is good

        dp[u][1][0] = 0; //total goods if u is one
        dp[u][1][1] = 1; //total cost if u is one
    }
    else{

        dp[u][0][0] = 1;
        dp[u][0][1] = 0;
        dp[u][1][0] = 0;
        dp[u][1][1] = 1;

        c = 0;

        for(int v: g[u]){
            c++;
            if(v == p) continue;
            //if u is good all neighbors are ones
            dp[u][0][0] += dp[v][1][0];
            dp[u][0][1] += dp[v][1][1];

            //if u is a one all neighbors may be good or ones
            if(dp[v][0][0] > dp[v][1][0] or
                 (dp[v][0][0] == dp[v][1][0] and dp[v][0][1] < dp[v][1][1]) ){ //make the child good
                dp[u][1][0] += dp[v][0][0];
                dp[u][1][1] += dp[v][0][1];
                gch[u].insert(v);
            }
            else {
                dp[u][1][0] += dp[v][1][0];
                dp[u][1][1] += dp[v][1][1];
            }
        }
        
    }

    dp[u][0][1] += c;

    // cout << u+1 << ": " << dp[u][0][0] << " " << dp[u][0][1] << ", " << dp[u][1][0] << " " << dp[u][1][1] << endl;
}

int res[N]; //one

void dfs2(int u, int p, int one){
    res[u] = 0;
    for(int v: g[u]){
        res[u]++;
        if(v == p) continue;
        if(one == 1 and gch[u].count(v)){
            dfs2(v, u, 0);
        }
        else{
            dfs2(v, u, 1);
        }
    }
    if(one == 1){
        res[u] = 1;
    }
}

int main(){
    int n;
    cin >> n;
    if(n == 2){
        int u, v;
        cin >> u >> v;
        cout << "2 2\n1 1\n";
    }
    else{
        for(int i = 0; i < n-1; i++){
            int u, v;
            cin >> u >> v;
            u--; v--;
            g[u].push_back(v);
            g[v].push_back(u);
        }
        for(int i = 0; i < n; i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = 0;
            dp[i][1][0] = 0;
            dp[i][1][1] = 0;
        }
        dfs(0, -1);
        int totgood = 0;
        int weight = 0;
        if(dp[0][0][0] > dp[0][1][0] or
                    (dp[0][0][0] == dp[0][1][0] and dp[0][0][1] < dp[0][1][1]) ){
            dfs2(0, -1, 0);
            totgood = dp[0][0][0];
            weight = dp[0][0][1];
        }
        else{
            dfs2(0, -1, 1);
            totgood = dp[0][1][0];
            weight = dp[0][1][1];
        }

        cout << totgood << ' ' << weight << '\n';
        for(int i = 0; i < n-1; i++){
            cout << res[i] << ' ';
        }
        cout << res[n-1] << '\n';
    }
}