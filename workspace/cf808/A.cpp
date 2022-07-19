#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

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
#define INF 1e9
int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n, q;
        cin >> n >> q;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        char s[n];
        int curr = 0;
        for(int i = n-1; i >= 0; i--){
            if(arr[i] <= curr){
                s[i] = '1';
            }
            else{
                if(curr < q){
                    s[i] = '1'; curr++;
                }
                else{
                    s[i] = '0';
                }
            }
        }
        for(int i = 0; i < n; i++){
            cout << s[i];
        }
        cout << endl;
    }
}