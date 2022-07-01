#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

ll calc(ll x[], ll y[], ll a[], ll b[], int p[]){
    ll res = 0;
    for(int i = 0; i < 4; i++){
        res += abs(a[i] - x[p[i]]);
        res += abs(b[i] - y[p[i]]);
    }
    return res;
}

int main(){
    int t;
    cin >> t;
    while(t--){
        ll x[4], y[4];
        ll res = 5;
        for(int i = 0; i < 4; i++){
            cin >> x[i] >> y[i];
            res += x[i] + y[i];
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    ll d = abs(x[i] - x[j]);
                    ll y1 = y[k] + d;
                    ll a[] = {x[i], x[i], x[j], x[j]};
                    ll b[] = {y[k], y1, y[k], y1};
                    int arr[] = {0, 1, 2, 3};
                    while(std::next_permutation(arr,arr+4)){
                        res = min(res, calc(x, y, a, b, arr));
                    }
                }
            }   
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    ll d = abs(x[i] - x[j]);
                    ll y2 = y[k] - d;
                    ll a[] = {x[i], x[i], x[j], x[j]};
                    ll b[] = {y[k], y2, y[k], y2};
                    int arr[] = {0, 1, 2, 3};
                    while(std::next_permutation(arr,arr+4)){
                        res = min(res, calc(x, y, a, b, arr));
                    }
                }
            }   
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    ll d = abs(y[i] - y[j]);
                    ll x1 = x[k] + d;
                    ll b[] = {y[i], y[i], y[j], y[j]};
                    ll a[] = {x[k], x1, x[k], x1};
                    int arr[] = {0, 1, 2, 3};
                    while(std::next_permutation(arr,arr+4)){
                        res = min(res, calc(x, y, a, b, arr));
                    }
                }
            }   
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    ll d = abs(y[i] - y[j]);
                    ll x2 = x[k] - d;
                    ll b[] = {y[i], y[i], y[j], y[j]};
                    ll a[] = {x[k], x2, x[k], x2};
                    int arr[] = {0, 1, 2, 3};
                    while(std::next_permutation(arr,arr+4)){
                        res = min(res, calc(x, y, a, b, arr));
                    }
                }
            }   
        }
        cout << res << '\n';
    }
}