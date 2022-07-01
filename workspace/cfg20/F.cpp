#include <iostream>
// #include <algorithm>
#include <queue>
#include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        map<int, queue<int> > ps;
        for(int i = 0; i < n; i++){
            ps[arr[i]].push(i);
        }
        int brr[n];
        while(!ps.empty()){
            int v = 0;
            vector<int> cycle;
            while(ps.upper_bound(v) != ps.end()){
                v = (*ps.upper_bound(v)).first;
                int p = ps[v].front();
                ps[v].pop();
                if(ps[v].empty()){
                    ps.erase(v);
                }
                cycle.push_back(p);
            }
            int m = cycle.size();
            for(int i = 0; i < m; i++){
                int p = cycle[i];
                int q = cycle[(i+1) % m];
                brr[p] = arr[q];
            }
        }
        for(int i = 0; i < n-1; i++){
            cout << brr[i] << ' ';
        }
        cout << brr[n-1] << '\n';
    }
}