#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
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
        int n, k;
        cin >> n >> k;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        if(k == 1){
            cout << (n-1)/2 << '\n';
        }
        else{
            int c = 0;
            for(int i = 1; i < n-1; i++){
                if(arr[i] > arr[i-1] + arr[i+1]) c++;
            }
            cout << c << '\n';
        }
    }

}