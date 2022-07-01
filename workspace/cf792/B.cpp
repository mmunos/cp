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
        ll a, b, c;
        cin >> a >> b >> c;
        ll z = c;
        ll y = b;
        ll x = a + z*y;
        cout << x << ' ' << y << ' ' << z << '\n';
    }
}
