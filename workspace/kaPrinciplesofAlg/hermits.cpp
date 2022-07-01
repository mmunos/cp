#include <iostream>
#include <vector>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    ll n;
    cin >> n;

    ll a[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }

    int m;
    cin >> m;

    vector<int> g[n];
    for(int i = 0; i < m; i++){
        int u, v;
        cin >> u >> v;
        u--; v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    ll minval = 2000000000;
    int minu = -1;
    for(int i = 0; i < n; i++){
        ll curr = a[i];
        for(int v: g[i]){
            curr += a[v];
        }
        if(curr < minval){
            minval = curr;
            minu = i;
        }
    }

    cout << minu + 1 << '\n';

    return 0;
}