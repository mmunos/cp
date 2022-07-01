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
        bool one = false;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            if(arr[i] == 1) one = true;
        }
        if(!one){
            cout << "YES\n";
        }
        else{
            sort(arr, arr+n);
            bool yes = true;
            for(int i = 0; i < n-1; i++){
                if(arr[i] == arr[i+1]-1) yes = false;
            }
            if(yes){
                cout << "YES\n";
            }
            else{
                cout << "NO\n";
            }
        }

    }


}