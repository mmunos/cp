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
        int n, m;
        cin >> n >> m;
        char mapp[n][m];
        for(int i = 0; i < n; i++){
            cin >> mapp[i];
        }
        int x = n, y = m;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mapp[i][j] == 'R'){
                    x = min(x, i);
                    y = min(y, j);
                }
            }
        }
        bool yes = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mapp[i][j] == 'R'){
                    if(i == x and j == y) yes = true;
                }
            }
        }
        if(yes) cout << "YES\n";
        else cout << "NO\n";
    }

}