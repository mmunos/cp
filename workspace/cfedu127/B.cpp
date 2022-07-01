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
        //x0--;
        bool yes = true;
        for(int i = 1; i < n; i++){
            if(abs(arr[i] - (arr[0] - 1 + i)) > 1) yes = false;
        }
        if(yes) {
            cout << "YES\n"; continue;
        }
        yes = true;
        for(int i = 1; i < n; i++){
            if(abs(arr[i] - (arr[0] + i)) > 1) yes = false;
        }
        if(yes) {
            cout << "YES\n"; continue;
        }
        yes = true;
        for(int i = 1; i < n; i++){
            if(abs(arr[i] - (arr[0] + 1 + i)) > 1) yes = false;
        }
        if(yes) {
            cout << "YES\n"; continue;
        }
        cout << "NO\n";
    }


}