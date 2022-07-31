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
    int n, x;
    cin >> n >> x;
    int N = 200001;
    bool arr[N];
    for(int i = 0; i < N; i++){
        arr[i] = false;
    }
    for(int i = 0; i < n; i++){
        int s, d;
        cin >> s >> d;
        for(int j = 0; j <= d; j++){
            arr[s+j] = true;
        }
    }
    int t = 0, c = INT32_MAX;
    for(int i = 0; i <= 480; i++){
        int ccurr = 0;
        int tcurr = i;
        while(tcurr < N){
            if(arr[tcurr]) ccurr++;
            tcurr += x;
        }
        if(ccurr < c){
            c = ccurr; t = i;
        }
    }
    cout << t << ' ' << c << '\n';
}