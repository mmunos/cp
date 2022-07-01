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
        ll b = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            b += arr[i];
        }
        sort(arr, arr+n);
        double res = -INFINITY;
        ll a = 0;
        for(int i = 0; i < n-1; i++){
            a += arr[i];
            b -= arr[i];
            double curr = a*1.0/(i+1) + b*1.0/(n-i-1);
            res = max(res, curr);
        }
        cout << setprecision(10) << res << '\n';
    }
}