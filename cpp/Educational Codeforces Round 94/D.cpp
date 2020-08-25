#include <iostream>
#include <unordered_map>
using namespace std;

#define ll long long

int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        ll crr[n+1];
        for(int j = 0; j <= n; j++) crr[j] = 0;
        crr[arr[0]]++;
        ll res = 0;
        for(int i = 1; i < n-2; i++){
            ll brr[n];
            for(int j = 0; j < n; j++) brr[j] = 0;
            for(int j = n-1; j > i; j--){
                if(j < n-1) brr[j] = brr[j+1];
                if(arr[j] == arr[i]){
                    brr[j]++;
                }
            }
            for(int j = i+1; j < n-1; j++){
                res += crr[arr[j]] * brr[j+1];
            }
            crr[arr[i]]++;
        }
        cout << res << "\n";
    }
}