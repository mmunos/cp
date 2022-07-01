#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>
#include <cmath>

using namespace std;

typedef long long int ll;

int code(int x, int y, int n){
    int x0 = n/2, y0 = n/2;
    int d = max(abs(x - x0), abs(y - y0));
    if(d == 0) return 1;
    if(x == x0 - d and y == y0 - d) return (2*d+1)*(2*d+1);
    int lastsq = (2*d-1)*(2*d-1);
    if(x == x0 - d) return lastsq + (y - (y0 - d));
    else if(y == y0 + d) return lastsq + 2*d + (x - (x0 - d));
    else if(x == x0 + d) return lastsq + 4*d + abs(y - (y0 + d));
    else return lastsq + 6*d + abs(x - (x0 + d));
}
pair<int, int> decode(int k, int n){
    int x0 = n/2, y0 = n/2;
    int sq = (int) sqrt(k);
    int d = sq / 2 + 1;
    if(sq * sq == k and sq % 2 == 1){
        return make_pair(x0 - d + 1, y0 - d + 1);
    }
    if(sq % 2 == 0) d--;
    int lastsq = (2*d-1)*(2*d-1);
    if(k <= lastsq + 2*d) return make_pair(x0 - d, y0 - d + k - lastsq);
    else if(k <= lastsq + 4*d) return make_pair(x0 - d + k - lastsq - 2*d, y0 + d);
    else if(k <= lastsq + 6*d) return make_pair(x0 + d, y0 + d - (k - lastsq - 4*d));
    else return make_pair(x0 + d - (k - lastsq - 6 * d), y0 - d);
}

int main(){
    // for(int i = 0; i < 9; i++){
    //     for(int j = 0; j < 9; j++){
    //         cout << 9*9 - code(j, i, 9) + 1 << '\t';
    //     }
    //     cout << endl;
    // }
    int T;
    cin >> T;
    int caso = 1;
    while(T--){
        int n, k;
        cin >> n >> k;
        if(k % 2 == 1 or k < n-1){
            cout << "Case #" << caso++ << ": IMPOSSIBLE\n";
        }
        else{
            int x0 = n/2, y0 = n/2;
            int a = 0, b = n*n;
            while(b - a > 1){
                int c = (a + b)/2;
                pair<int, int> p = decode(n*n - c + 1, n);
                int dist = abs(x0 - p.second) + abs(y0 - p.first);
                // cout << c << " " << dist << endl;
                if(c-1 + dist >= k){
                    b = c;
                }
                else{
                    a = c;
                }
            }
            // cout << "b " << b << endl; 
            pair<int, int> pa = decode(n*n - b + 1, n);
            vector<int> route;
            route.push_back(b);
            int x = pa.first, y = pa.second;
            while(x != x0 or y != y0){
                if(x < x0 and y <= y0) x++;
                else if(x >= x0 and y < y0) y++;
                else if(x > x0 and y >= y0) x--;
                else y--;
                // cout << "xy" << x << ' ' << y << endl;
                int v = code(x, y, n);
                route.push_back(n*n - v + 1);
            }
            vector<pair<int,int> > realroute;
            int m = route.size();
            for(int i = 0; i < m-1; i++){
                if(route[i] + 1 != route[i+1]){
                    realroute.push_back(make_pair(route[i], route[i+1]));
                }
            }

            cout << "Case #" << caso++ << ": " << realroute.size() << "\n";
            for(pair<int, int> p: realroute){
                cout << p.first << ' ' << p.second << '\n';
            }
        }
    }

}