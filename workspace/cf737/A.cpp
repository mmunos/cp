#include <iostream>
#include <iomanip>
#include <algorithm> 
using namespace std;

#define ll long long

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        ll arr[n];
        ll amax = -1e9;
        ll tot = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            amax = max(amax, arr[i]);
            tot += arr[i];
        }
        double res = amax + (tot-amax)*1.0/(n-1);
        cout << setprecision(10) << res << '\n';
    }
}