#include <iostream>
#include <algorithm>
#include <numeric>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        ll n;
        cin >> n;
        ll aux = n;
        while(aux % 2 == 0) aux /= 2;
        if(aux == 1){
            cout << "-1\n";
        }
        else{
            ll a = aux;
            ll b = 2 * n / aux;
            if(a < b){
                cout << a << '\n';
            }
            else{
                cout << b << '\n';
            }
        }
    }


}