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

using namespace std;

#define ll long long

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        string s, t;
        cin >> s; cin >> t;
        if(s[0] != t[0] or s[n-1] != t[n-1]){
            cout << "-1\n";
        }
        else{
            vector<pair<ll, ll> > arr;
            vector<pair<ll, ll> > brr;
            int x = -1;
            for(int i = 0; i < n; i++){
                if(s[i] == '1' and x < 0) x = i;
                else if(s[i] == '1' and x >= 0);
                else if(s[i] == '0' and x < 0);
                else{
                    arr.push_back(make_pair(x, i));
                    x = -1;
                } 
            }
            if(x >= 0){
                arr.push_back(make_pair(x, n));
            }
            x = -1;
            for(int i = 0; i < n; i++){
                if(t[i] == '1' and x < 0) x = i;
                else if(t[i] == '1' and x >= 0);
                else if(t[i] == '0' and x < 0);
                else{
                    brr.push_back(make_pair(x, i));
                    x = -1;
                } 
            }
            if(x >= 0){
                brr.push_back(make_pair(x, n));
            }
            int m = arr.size();
            if(brr.size() != m){
                cout << "-1\n";
            }
            else{
                ll res = 0;
                for(int i = 0; i < m; i++){
                    res += abs(arr[i].first - brr[i].first)
                            + abs(arr[i].second - brr[i].second);
                }
                cout << res << '\n';
            }
        }
    }
}