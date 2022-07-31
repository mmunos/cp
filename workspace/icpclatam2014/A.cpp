#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int x = 0, y = 0;
    for(int i = 0; i < 5; i++){
        int a;
        cin >> a;
        x += (a << i);
    }
    for(int i = 0; i < 5; i++){
        int a;
        cin >> a;
        y += (a << i);
    }
    if((x ^ y) == 31) cout << "Y\n";
    else cout << "N\n";
    return 0;
}