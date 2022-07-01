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
        int arr[n], brr[n];
        int count[n+1];
        for(int i = 0; i <= n; i++){
            count[i] = 0;
        }
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        for(int i = 0; i < n; i++){
            cin >> brr[i];
        }
        if(arr[n-1] != brr[n-1]){
            cout << "NO\n"; continue;
        }
        int j = n-2;
        bool yes = true;
        for(int i = n-2; i >= 0 and j >= 0; i--, j--){
            while(j >= 0 and arr[i] != brr[j]){
                if(brr[j] != brr[j+1]){
                    if(count[arr[i]] == 0){
                        yes = false; break;
                    }
                    else{
                        count[arr[i]]--;
                        i--;
                    }
                }
                else{
                    count[brr[j]]++;
                    j--;
                }
            }
            if(!yes) break;
        }
        if(yes) cout << "YES\n";
        else cout << "NO\n";
    }
}