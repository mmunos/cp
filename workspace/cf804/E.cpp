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

const int N = 5000000;
int divs[N+1];

int main(){
    for(int i = 0; i <= N; i++){
        divs[i] = -1;
    }
    for(ll i = 1; i <= N; i++){
        for(ll j = i; j <= N; j += i){
            if(i*i <= j and i > divs[j]) divs[j] = i;
        }
    }
    for(int i = 1; i <= N; i++){
        cout << i << ": " << divs[i] << endl;
    }
    int T;
    cin >> T;
    while(T--){
        int n, m;
        cin >> n >> m;
        bool vals[m+1];
        int minv = m, maxv = 1;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            vals[a] = true;
            minv = min(minv, a);
            maxv = max(maxv, a);
        }  
        
    }
}