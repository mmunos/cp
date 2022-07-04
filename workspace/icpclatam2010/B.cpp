#include <iostream>
// #include <algorithm>
// #include <queue>
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
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, b;
    while(cin >> n >> b){
        if(n == 0 and b == 0) break;
        int arr[b];
        for(int i = 0; i < b; i++){
            cin >> arr[i];
        }
        bool check[n+1];
        for(int i = 0; i <= n; i++){
            check[i] = false;
        }
        for(int i = 0; i < b; i++){
            for(int j = 0; j < b; j++){
                if(abs(arr[i] - arr[j]) <= n){
                    check[abs(arr[i] - arr[j])] = true;
                }
            }
        }
        string res = "Y";
        for(int i = 0; i <= n; i++){
            if(!check[i]) res = "N";
        }
        cout << res << endl;
    }

    return 0;
}