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
ll mod = 998244353;

int main(){
    int T;
    cin >> T;
    int caso = 1;
    while(T--){
        int arr[3][4];
        int mins[4] = {1000000, 1000000, 1000000, 1000000};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                cin >> arr[i][j];
                mins[j] = min(mins[j], arr[i][j]);
            }
        }
        int tot = 0;
        
        for(int i = 0; i < 4; i++){
            tot += mins[i];
            if(tot >= 1000000){
                mins[i] -= tot - 1000000;
                tot = 1000000;
            }
        }
        cout << "Case #" << caso++ << ": ";
        if(tot < 1000000){
            cout << "IMPOSSIBLE\n";
        }
        else{
            cout << mins[0] << ' ' << mins[1] << ' ' << mins[2] << ' ' << mins[3] << '\n';
        }
    }

}