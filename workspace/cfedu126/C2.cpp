#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
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
        int maxa = 0;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            maxa = max(maxa, arr[i]);
        }  
        ll ones = 0, twos = 0;
        ll tot = 0;
        for(int i = 0; i < n; i++){
            int d = maxa - arr[i];
            tot += d;
            twos += d / 2;
            if(d % 2 == 1) ones++;
        }
        ll r1 = tot / 3 * 2 + (tot % 3);
        ll r2 = ones * 2 - 1;
        cout << max(r1, r2) << endl;
    }
}