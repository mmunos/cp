#include <iostream>
#include <algorithm>
#include <queue>
// #include <map>
#include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, z;
        cin >> n >> z;
        int res = 0;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            res = max(res, a | z);
        }
        cout << res << '\n';
    }

}