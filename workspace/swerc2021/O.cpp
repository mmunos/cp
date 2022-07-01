#include <iostream>
// #include <algorithm>
#include <queue>
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
        bool maph[21][360];
        bool mapv[21][360];
        bool seen[21][360];
        for(int i = 0; i <= 20; i++){
            for(int j = 0; j < 360; j++){
                maph[i][j] = false;
                mapv[i][j] = false;

                seen[i][j] = false;
            }
        }
        for(int i = 0; i < n; i++){
            string s;
            cin >> s;
            if(s[0] == 'C'){
                int a, b, c;
                cin >> a >> b >> c;
                if(b < c){
                    for(int i = b; i < c; i++){
                        maph[a][i] = true;
                    }
                }
                else{
                    for(int i = b; i < c + 360; i++){
                        maph[a][i % 360] = true;
                    }
                }
            }
            else{
                int a, b, c;
                cin >> a >> b >> c;
                for(int i = a; i < b; i++){
                    mapv[i][c] = true;
                }
            }
        }
        queue<pair<int, int> > q;
        for(int i = 0; i < 360; i++){
            q.push(make_pair(20, i));
            seen[20][i] = true;
        }
        while(!q.empty()){
            pair<int, int> p = q.front();
            int x0 = p.first, y0 = p.second;
            q.pop();
            //right
            if(!mapv[x0][(y0+1)%360]){
                int x = x0, y = y0 + 1;
                if(y == 360) y = 0;
                if(!seen[x][y]){
                    q.push(make_pair(x, y));
                    seen[x][y] = true;
                }
            }
            //left
            if(!mapv[x0][y0]){
                int x = x0, y = y0 - 1;
                if(y < 0) y = 359;
                if(!seen[x][y]){
                    q.push(make_pair(x, y));
                    seen[x][y] = true;
                }
            }
            //up
            if(x0 < 20 and !maph[x0+1][y0]){
                int x = x0+1, y = y0;
                if(!seen[x][y]){
                    q.push(make_pair(x, y));
                    seen[x][y] = true;
                }
            }
            //down
            if(x0 >= 1 and !maph[x0][y0]){
                int x = x0-1, y = y0;
                if(!seen[x][y]){
                    q.push(make_pair(x, y));
                    seen[x][y] = true;
                }
            }
        }

        if(seen[0][0]) cout << "YES\n";
        else cout << "NO\n";
    }

}