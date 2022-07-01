#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;
ll mod = 998244353;

int main(){
    int T;
    cin >> T;
    int k = 17;
    while(T--){
        int l, r;
        cin >> l >> r;
        int n = r-l+1;
        int trueones[k];
        for(int i = 0; i < k; i++){
            trueones[i] = 0;
        }
        for(int i = l; i <= r; i++){
            for(int j = 0; j < k; j++){
                if(i & (1 << j)) trueones[j]++;
            }
        }
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        int ones[k];
        for(int i = 0; i < k; i++){
            ones[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                if(arr[i] & (1 << j)) ones[j]++;
            }
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            // cout << ones[i] << ' ' << trueones[i] << '\n';
            if(ones[i] != trueones[i]){
                res += (1 << i);
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] ^= res;
        }
        //check
        bool check = false;
        for(int i = 0; i < n; i++){
            if(arr[i] < l or arr[i] > r) check = true;
        }
        if(check){
            for(int j = k-1; j >= 0; j--){
                if(ones[j] == n/2){
                    res += (1 << j); break;
                }
            }
        }
        cout << res << '\n';
    }

}