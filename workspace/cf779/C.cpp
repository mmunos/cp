#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
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
        int one = -1;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            if(arr[i] == 1){
                if(one == -1) one = i;
                else one = -2;
            }
        }
        if(one < 0){
            cout << "NO\n";
            continue;
        }
        bool valid = true;
        for(int i = 0; i < n-1; i++){
            int inda = (i + one) % n;
            int indb = (i + one + 1) % n;
            if(arr[indb] > arr[inda]){
                if(arr[indb] != arr[inda] + 1) valid = false;
            }
        }
        if(valid) cout << "YES\n";
        else cout << "NO\n";
    }

}