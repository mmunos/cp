#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        ll arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        sort(arr, arr+n);
        ll left = arr[0], right = 0;
        int x = 1, y = n-1;
        bool found = false;
        while(x < y){
            left += arr[x]; right += arr[y];
            if(left < right) found = true;
            x++; y--;
        }
        if(found){
            cout << "YES\n";
        }
        else{
            cout << "NO\n";
        }
    }

}