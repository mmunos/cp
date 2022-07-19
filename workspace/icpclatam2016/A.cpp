#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <vector>
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
    int c[4];
    for(int i = 0; i < 4; i++){
        cin >> c[i];
    }
    cout << abs(c[0] - c[1] - c[2] + c[3]) << '\n';
}