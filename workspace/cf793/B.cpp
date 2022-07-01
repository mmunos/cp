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
        int n;
        cin >> n;
        int arr[n], brr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            brr[i] = arr[i];
        }
        sort(brr, brr+n);
        int res = 1048575;
        for(int i = 0; i < n; i++){
            if(arr[i] != brr[i]){
                res &= arr[i];
            }
        }
        cout << res << '\n';
    }
}
