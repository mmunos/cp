#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>
// #include <functional>

using namespace std;

#define ll long long

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int a[3], b[3];
    for(int i = 0; i < 3; i++){
        cin >> a[i];
    }
    for(int i = 0; i < 3; i++){
        cin >> b[i];
    }
    int tot = 0;
    for(int i = 0; i < 3; i++){
        tot += max(0, b[i] - a[i]);
    }
    cout << tot << '\n';
}