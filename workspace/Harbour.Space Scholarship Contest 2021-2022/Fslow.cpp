#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

int N = 300003;
int sqN = 560;

int main(){
    int n;
    cin >> n;
    int sqn = sqrt(n);
    ll arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    for(int iter = 1; iter <= n; iter++){
        ll res = 0;
        for(int i = 0; i < iter; i++){
            for(int j = 0; j < iter; j++){
                res += arr[i] % arr[j];
            }
        }
        cout << res << ' ';
    }
    cout << endl;
}