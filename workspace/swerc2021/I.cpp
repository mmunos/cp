#include <iostream>
#include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
#include <math.h>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    // cin >> T;
    T = 1;
    while(T--){
        int n, m;
        cin >> n >> m;
        ll arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        // for(int i = 0; i < n; i++){
        //     cout << arr[i] << ' ';
        // }
        // cout << '\n';
        ll acc[n+1];
        acc[0] = 0;
        for(int i = 1; i <= n; i++){
            acc[i] = acc[i-1] + arr[i-1];
        }
        int brr[m];
        for(int i = 0; i < m; i++){
            cin >> brr[i];
        }
        sort(brr, brr + m);
        int first = (int) ceil(brr[0]*1.0 / 100);
        first = min(first, n);
        ll res = acc[first];
        // cout << "first " << first << " - res " << res << endl;
        for(int i = 0; i < m-1; i++){
            double p = 0.1 + brr[i];
            double mid = (p + brr[i+1])*0.5;
            // cout << mid << endl;
            int right = (int) ceil(mid/100);
            int left = (int) ceil(p * 1.0/100);
            // cout << "left " << left << " right " << right << endl;
            ll val = acc[min(right, n)] - acc[min(left, n)];
            res = max(res, val);
            // cout << "2 " << val << endl;
            while(right * 100 < brr[i+1]){
                double p = 0.1 + right * 100 - (brr[i+1] - right * 100);
                // cout << "p " << p << endl;
                mid = (p + brr[i+1])*0.5;
                right = (int) ceil(mid/100); //right++
                double mid2 = (p + brr[i])/2;
                left = (int) floor(mid2/100) + 1;
                ll val = acc[min(right, n)] - acc[min(left, n)];
                // cout << "3 " << val << endl;
                res = max(res, val);
            }
        }
        int last = (int) ceil((brr[m-1] + 0.1) * 1.0/100);
        last = min(last, n);
        ll lastval = acc[n] - acc[last];
        // cout << "last " << last << " lastval " << lastval << endl;
        res = max(res, lastval);
        cout << res << '\n';
    }

}