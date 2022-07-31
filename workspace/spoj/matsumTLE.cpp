// #pragma GCC optimize("Ofast")
// #pragma GCC target("bmi,bmi2,lzcnt,popcnt")
// #pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

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
// #include <functional>

using namespace std;

#define ll long long

int T, n;
int x1, y1, x2, y2, val;
string inst;
int mat[1024][1025];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> T;
    while(T--){
        cin >> n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                mat[i][j] = 0;
            }
        }
        while(cin >> inst){
            if(inst == "END") break;
            else if(inst == "SET"){
                cin >> x1 >> y1 >> val;
                int c = mat[x1][y1+1] - mat[x1][y1];
                for(int i = y1+1; i <= n; i++){
                    mat[x1][i] += val - c;
                }
            }
            else if(inst == "SUM"){
                cin >> x1 >> y1 >> x2 >> y2;
                int tot = 0;
                for(int i = x1; i <= x2; i++){
                    tot += mat[i][y2+1] - mat[i][y1];
                }
                cout << tot << '\n';
            }
        }
    }
}