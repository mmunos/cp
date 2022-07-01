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


using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        ll n;
        cin >> n;
        if(n < 100){
            cout << n % 10 << '\n';
        }
        else{
            ll d = 9;
            while(n > 0){
                d = min(d, n % 10);
                n /= 10;
            }
            cout << d << '\n';
        }
    }
}
