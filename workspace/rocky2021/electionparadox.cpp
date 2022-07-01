#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int n;
    cin >> n;
    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    sort(arr, arr + n);
    int res = 0;
    for(int i = n-1; i >= 0; i--){
        if(i > n/2){
            res += arr[i];
        }
        else{
            res += arr[i]/2;
        }
    }
    cout << res << '\n';

}