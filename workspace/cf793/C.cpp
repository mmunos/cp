#include <iostream>
#include <algorithm>
#include <queue>
#include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>


using namespace std;

typedef long long int ll;

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
        sort(arr, arr+n);
        int count = 2;
        for(int i = 0; i < n-2; i++){
            if(arr[i] != arr[i+2]){
                count++;
            }
        }
        cout << (count+1)/2 << '\n';
    }
}
