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
ll mod = 998244353;

int main(){
    int N = 1001;
    ll fac[N];
    fac[0] = 1;
    for(int i = 1; i < N; i++){
        fac[i] = fac[i-1] * i % mod;
    }
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        if(n % 2 == 0){
            cout << fac[n/2] * fac[n/2] % mod << '\n';
        }
        else{
            cout << "0\n";
        }
    }

}