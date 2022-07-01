#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int n, k;
    cin >> n >> k;
    int arr[k];
    for(int i = 0; i < k; i++){
        cin >> arr[i];
    }
    int res = 0;
    for(int i = 0; i < k-1; i++){
        int d = arr[i+1] - arr[i];
        res += (d-2)/2;
    }
    res += (n-arr[k-1]+arr[0]-2)/2;
    cout << res << '\n';
}