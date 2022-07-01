#include <iostream>
#include <algorithm>
#include <vector>
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
        int n, m;
        cin >> n >> m;
        vector<pair<ll, ll> > arr;
        for(int i = 0; i < n; i++){
            ll a;
            cin >> a;
            ll e = 1;
            while(a % m == 0){
                a /= m;
                e *= m;
            }
            if(arr.size() == 0){
                arr.push_back(make_pair(a, e));
            }
            else{
                if(arr.back().first == a){
                    arr.back().second += e;
                }
                else{
                    arr.push_back(make_pair(a, e));
                }
            }
        }
        // for(int i = 0; i < arr.size(); i++){
        //     cout << arr[i].first << " " << arr[i].second << endl;
        // }
        // cout << "lu\n";
        int k;
        cin >> k;
        vector<pair<ll, ll> > brr;
        for(int i = 0; i < k; i++){
            ll a;
            cin >> a;
            ll e = 1;
            while(a % m == 0){
                a /= m;
                e *= m;
            }
            if(brr.size() == 0){
                brr.push_back(make_pair(a, e));
            }
            else{
                if(brr.back().first == a){
                    brr.back().second += e;
                }
                else{
                    brr.push_back(make_pair(a, e));
                }
            }
        }
        if(arr.size() != brr.size()){
            cout << "No\n";
        }
        else{
            int s = arr.size();
            bool eq = true;
            for(int i = 0; i < s; i++){
                if(arr[i].first != brr[i].first) eq = false;
                if(arr[i].second != brr[i].second) eq = false;
            }
            if(eq){
                cout << "Yes\n";
            }
            else{
                cout << "No\n";
            }
        }

    }

}