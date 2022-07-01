#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

void printarr(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout << arr[i] << ' ';
    }
    cout << endl;
}

typedef long long int ll;

int main(){
    int T = 1;
    while(T--){
        int n; ll k;
        cin >> n >> k;
        ll arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        ll acc[n+1];
        acc[0] = 0;
        for(int i = 0; i < n; i++){
            acc[i+1] = acc[i] + arr[i];
        }
        ll count[n+1];
        count[0] = 0;
        for(int i = 0; i < n; i++){
            count[i+1] = count[i];
            if(arr[i] == 0) count[i+1]++;
        }
        if(abs(acc[n]) > count[n] * k) cout << "-1\n";
        else{
            ll res = 0;
            for(int i = 0; i < n+1; i++){
                for(int j = i+1; j < n+1; j++){
                    // cout << "i: " << i << endl;
                    // cout << "j: " << j << endl;
                    int c = count[j] - count[i];
                    // cout << "c: " << c << endl;
                    //val i < val j
                    ll dif1 = acc[j] - acc[i] + c * k;
                    // cout << "dif1: " << dif1 << endl;
                    ll mini = acc[i] - count[i] * k;
                    // cout << "mini: " << mini << endl;
                    ll maxj = acc[j] - acc[n] + (count[n] - count[j]) * k;
                    // cout << "maxj: " << maxj << endl;
                    res = max(res, min(dif1, maxj - mini));

                    //val i > val j
                    ll dif2 = acc[i] - acc[j] + c * k;
                    // cout << "dif2: " << dif2 << endl;
                    ll maxi = acc[i] + count[i] * k;
                    // cout << "maxi: " << maxi << endl;
                    ll minj = -acc[n] + acc[j] - (count[n] - count[j]) * k;
                    // cout << "minj: " << minj << endl;
                    res = max(res, min(dif2, maxi - minj));
                }
            }
            cout << res + 1 << '\n';
        }
    }

}