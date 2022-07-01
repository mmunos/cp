#include <iostream>
// #include <algorithm>
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
        int n, k;
        cin >> n >> k;
        int arr[n];
        set<int> s;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            s.insert(arr[i]);
        }
        if(k == 0){
            if(s.size() < n){
                cout << "YES\n";
            }
            else{
                cout << "NO\n";
            }
        }
        else{
            bool yes = false;
            for(int i = 0; i < n; i++){
                if(s.count(k + arr[i])) yes = true;
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