#include <iostream>
// #include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int tot = 0;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            tot += a-1;
        }
        if(tot % 2 == 0) cout << "maomao90\n";
        else cout << "errorgorn\n";
    }
}