#include <iostream>
#include <algorithm>
#include <queue>
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
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        int x = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0) {
                x = i; break;
            }
        }
        if(x == -1){
            cout << "0\n"; continue;
        }
        int y;
        for(int i = n-1; i >= 0; i--){
            if(arr[i] != 0){
                y = i; break;
            }
        }
        bool z = true;
        for(int i = x; i <= y; i++){
            if(arr[i] == 0){
                z = false;
            }
        }
        if(z){
            cout << "1\n";
        }
        else{
            cout << "2\n";
        }
    }

}