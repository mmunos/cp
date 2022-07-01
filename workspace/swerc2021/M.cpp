#include <iostream>
// #include <algorithm>
// #include <queue>
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
        int n, m;
        cin >> n >> m;
        int r[m], w[m];
        int maxr = 0, maxw = 0;
        for(int i = 0; i < m; i++){
            cin >> r[i] >> w[i];
            maxr = max(maxr, r[i]);
            maxw = max(maxw, w[i]);
        }
        if(maxr + maxw <= n){
            stringstream ss;
            for(int i = 0; i < maxr; i++){
                ss << 'R';
            }
            for(int i = 0; i < maxw; i++){
                ss << 'W';
            }
            for(int i = 0; i < n - maxr - maxw; i++){
                ss << 'W';
            }
            cout << ss.str() << '\n';
        }
        else{
            cout << "IMPOSSIBLE\n";
        }
    }

}