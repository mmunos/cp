#include <iostream>
// #include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

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
        int max = 0, maxi = 0;
        int min = 1000000000, mini = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i]; maxi = i;
            }
            if(arr[i] < min){
                min = arr[i]; mini = i;
            }
        }
        cout << (mini+1) << ' ' << (maxi+1) << '\n';
    }


}