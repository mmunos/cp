#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
#include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int a[3], b[2];
    while(cin >> a[0] >> a[1] >> a[2] >> b[0] >> b[1]){
        set<int> s;
        s.insert(a[0]);
        s.insert(a[1]);
        s.insert(a[2]);
        s.insert(b[0]);
        s.insert(b[1]);
        if(a[0] == 0) break;
        sort(a, a+3); sort(b, b+2);
        int val = 53;
        if(a[2] < b[0]) val = 1;
        else if(a[1] < b[0]) val = a[1]+1;
        else if(a[2] < b[1]) val = a[2]+1;
        while(s.count(val)) val++;
        if(val > 52) cout << "-1\n";
        else cout << val << '\n';
    }

    return 0;
}