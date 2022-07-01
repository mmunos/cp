#include <iostream>
#include <algorithm>
#include <queue>
#include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>


using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, k;
        cin >> n >> k;
        int arr[n];
        set<int> vals;
        priority_queue<int> q;
        for(int i = 0; i < n; i++){
            cin >> arr[i]; 
            vals.insert(arr[i]);
            q.push(arr[i]);
        }
        int mex = 0;
        for(int x: vals){
            if(x == mex) mex++;
            else break;
        }
        // cout << "mex: " << mex << endl;
        int c = 0;
        for(int iter = 0; iter < k; iter++){
            int v = q.top(); q.pop();
            // cout << "v: " << v << endl;
            if(v <= mex) break;
            c++;
            mex++;
            while(vals.count(mex)) mex++;
        }
        // cout << "c: " << c << endl;
        // cout << "mex: " << mex << endl;
        map<int, int> count;
        for(int i = 0; i < n; i++){
            if(arr[i] >= mex){
                count[arr[i]]++;
            }
        }
        // for (auto& it: count) {
        //     cout << it.first << ": " << it.second << endl;
        // }
        int res = vals.size() - mex;
        // cout << "res: " << res << endl;
        priority_queue<int, vector<int>, greater<int>> q2;
        for (auto& it: count) {
            q2.push(it.second);
        }
        while(!q2.empty()){
            int kk = q2.top(); q2.pop();
            // cout << "kk: " << kk << endl;
            if(kk >= c) {
                res += c-1; break;
            }
            else {
                res += kk-1;
                c -= kk;
            }
        }
        cout << res << '\n';
    }
}
