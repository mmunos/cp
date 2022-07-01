#include <iostream>
// #include <algorithm>
#include <queue>
#include <map>
// #include <unordered_map>
#include <set>
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
        set<int> vals;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            vals.insert(arr[i]);
        }
        int brr[n];
        for(int i = 0; i < n; i++){
            cin >> brr[i];
        }
        int res = n - vals.size() - 1;
        queue<int> ps[n+1];
        for(int i = 0; i < n; i++){
            ps[brr[i]].push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] < 0) continue;
            int p = i, val = arr[i];
            while(true){
                int v = arr[p]; ans++;
                int q = ps[v].front();
                ps[v].pop();
                if(arr[q] == val) break;
            }
        }
        if(ans == res){
            cout << "AC\n";
        }
        else{
            cout << "WA\n";
        }
    }
}