#include <iostream>
// #include <algorithm>
#include <stack>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>

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
        ll as[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                as[i][j] = 0;
            }
            for(int j = 0; j < i; j++){
                if(arr[j] < n) as[i][arr[j]+1] = 1;
            }
            for(int j = 1; j < n+1; j++){
                as[i][j] += as[i][j-1];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                cout << as[i][j] << ' ';
            }
            cout << endl;
        }
        ll ds[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                ds[i][j] = 0;
            }
            for(int j = i+1; j < n; j++){
                if(arr[j] < n) ds[i][arr[j]+1] = 1;
            }
            for(int j = 1; j < n+1; j++){
                ds[i][j] += ds[i][j-1];
            }
        }
        ll res = 0;

        //6
        //  i j
        //5 3 6 1 4 2
        //
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                ll v = as[i][arr[j]] * ds[j][arr[i]];
                // cout << i << ' ' << j << ' ' << v << endl;
                res += v;
            }
        }
        cout << res << '\n';
    }

}