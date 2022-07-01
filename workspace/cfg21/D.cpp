#include <iostream>
#include <algorithm>
#include <queue>
// #include <map>
#include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

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
        if(n == 1){
            cout << "0\n"; continue;
        }
        int imax = 0, imin = 0;
        int icurr = 0;
        int dist[n];
        for(int i = 0; i < n; i++){
            dist[i] = -1;
        }
        dist[0] = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[imax]){
                imax = i;
            }
            if(arr[i] < arr[imin]){
                imin = i;
            }
            if(icurr != imax and icurr != imin){
                int inext = min(imax, imin);
                dist[inext] = dist[icurr] + 1;
                icurr = inext;
            }
        }
        int distrev[n];
        for(int i = 0; i < n; i++){
            distrev[i] = -1;
        }
        dist[n-1] = 0;
        imax = n-1, imin = n-1;
        for(int i = n-2; i >= 0; i--){
            if(arr[i] > arr[imax]){
                imax = i;
            }
            if(arr[i] < arr[imin]){
                imin = i;
            }
            if(icurr != imax and icurr != imin){
                int inext = max(imax, imin);
                distrev[inext] = distrev[icurr] + 1;
                icurr = inext;
            }
        }
        int res = 1;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1 or arr[i] == n) res += max(dist[i], distrev[i]);
        }
        cout << res << '\n';
    }

}