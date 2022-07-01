#include <iostream>
#include <algorithm> 
#include <vector> 
#include <unordered_set> 
using namespace std;

#define ll long long

int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int g[n];
        for (int i = 0; i < n; i++) {
            cin >> g[i]; 
        }
        ll s[n];
        for (int i = 0; i < n; i++){
            cin >> s[i];
        }
        vector<int> gs[n];
        for (int i = 0; i < n; i++){
            gs[g[i]-1].push_back(s[i]);
        }
        for (int i = 0; i < n; i++){
            sort(gs[i].begin(), gs[i].end());
        }
        vector<ll> acc[n+1];
        unordered_set<int> sizes;
        for (int i = 0; i < n; i++){
            int m = gs[i].size();
            if(m == 0) continue;
            if(sizes.count(m)){
                ll curr = 0;
                for (int j = 0; j < m; j++){
                    curr += gs[i][j];
                    acc[m][j+1] += curr;
                }
            }
            else{
                ll curr = 0;
                acc[m].push_back(curr);
                for (int j = 0; j < m; j++){
                    curr += gs[i][j];
                    acc[m].push_back(curr);
                }
                sizes.insert(m);
            }
        }
        
        for (int i = 1; i <= n; i++){
            sizes.begin();
            ll x = 0;
            for (auto m = sizes.begin(); m != sizes.end(); ++m) {
                ll v = acc[*m][*m];
                int d = (*m) % i;
                v -= acc[*m][d];
                x += v;
            }
           if(i == n) cout << x << '\n';
           else cout << x << ' ';
        }
    }
}