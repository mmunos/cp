#include <iostream>
#include <cmath>
#include <algorithm> 
#include <set>
#include <vector>
#include <unordered_map>
using namespace std;

typedef long long int ll;



int main(){
    int T;
    cin >> T;
    while(T--){
        int n, m;
        cin >> n >> m;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        set<pair<int, int> > ps;
        for(int i = 0; i < m; i++){
            int x, y;
            cin >> x >> y;
            if(x > y) swap(x, y);
            pair<int, int> p1 = make_pair(x, y);
            ps.insert(p1);
        }

        // for (auto& it: ps) {
        //     cout << it.first << "," << it.second << endl;
        // }
        // cout << endl;

        unordered_map<int, int> ms;
        for(int i = 0; i < n; i++){
            ms[arr[i]]++;
        }
        // for (auto& it: ms) {
        //     cout << it.first << ": " << it.second << endl;
        // }
        // cout << endl;

        unordered_map<int, vector<int> > group;
        for(auto& it: ms){
            int k = it.first;
            int v = it.second;
            group[v].push_back(k);
        }

        // for (auto& it: group) {
        //     cout << it.first << ": ";
        //     for(int x: it.second){
        //         cout << x << ", ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;

        for(auto& it: group){
            sort(it.second.begin(), it.second.end());
        }

        // for (auto& it: group) {
        //     cout << it.first << ": ";
        //     for(int x: it.second){
        //         cout << x << ", ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;

        ll res = 0;
        for(auto& it1: group){
            int c1 = it1.first;
            for(auto& it2: group){
                int c2 = it2.first;
                if(c1 < c2) continue;
                int n1 = it1.second.size();
                for(int i = n1-1; i >= 0; i--){
                    int x = it1.second[i];
                    int n2 = it2.second.size();
                    for(int j = n2-1; j >= 0; j--){
                        int y = it2.second[j];
                        if(x == y) continue;
                        pair<int, int> p;
                        if(x < y){
                            p = make_pair(x, y);
                        }
                        else{
                            p = make_pair(y, x);
                        }

                        // cout << p.first << "," << p.second << endl;

                        if(!ps.count(p)){
                            // cout << "bye" << endl;

                            ll tot = (ll)(c1 + c2) * (ll)(x+y);
                            // cout << tot << endl;
                            res = max(res, tot);
                            break;
                        }
                    }
                }
            }
        }

        cout << res << '\n';
    }
}