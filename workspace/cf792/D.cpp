#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
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
        ll tot = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            tot += arr[i];
        }
        for(int i = 0; i < n; i++){
            arr[i] -= (n-i-k);
            // cout << arr[i] << ' ';
        }
        // cout << endl;
        sort(arr, arr+n);
        ll sub = 0;
        ll c = 0;
        for(int i = n-k; i < n; i++){
            sub += arr[i];
            sub -= c; c++;
        }
        cout << tot - sub << '\n';
    }
}
