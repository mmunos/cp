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
        int count = 0;
        for(int i = 1; i < n; i++){
            if(arr[i-1] == arr[i]) count++;
        }
        if(count <= 1){
            cout << "0\n";
        }
        else{
            int res = 0;
            for(int i = 1; i < n-1; i++){
                if(arr[i-1] == arr[i]){
                    if(arr[i-1] == arr[i]) count--;
                    if(arr[i] != arr[i+1]) count++;
                    if(i < n-2 and arr[i+1] == arr[i+2]) count--;
                    arr[i] = -i; arr[i+1] = -i; res++;
                    if(count <= 1){
                        break;
                    }
                }
                // for(int i = 0; i < n; i++){
                //     cout << arr[i] << ' ';
                // }
                // cout << endl;
            }
                // for(int i = 0; i < n; i++){
                //     cout << arr[i] << ' ';
                // }
                // cout << endl;
            cout << res << '\n';
        }
    }
}