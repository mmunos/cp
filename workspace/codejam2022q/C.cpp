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
    int caso = 1;
    while(T--){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        sort(arr, arr+n);
        int res = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] >= res+1) res++;
        }
        cout << "Case #" << caso++ << ": " << res << '\n';

    }

}