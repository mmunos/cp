#include <iostream>
// #include <algorithm>
#include <stack>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        ll a, b, c, d;
        cin >> a >> b >> c >> d;
        if(b < c or d < a){
            cout << a + c << endl;
        }
        else{
            cout << max(a, c) << endl;
        }
    }

}