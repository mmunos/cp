#include <iostream>
#include <map>
using namespace std;

typedef long long int ll;
int const N = 200001;

map<pair<int,int>, int> coors;
int dp[4][N];
pair<int, int> res[4][N];

int calc(int x, int y, int dir, int dx, int dy){
    pair<int, int> p = make_pair(x, y);
    int ind = coors[p];
    // cout << x << ' ' << y << ": " << ind << endl;
    if(dp[dir][ind] >= 0){
        return dp[dir][ind];
    }
    else{
        int x1 = x, y1 = y + dy;
        pair<int, int> p1 = make_pair(x1, y1);
        if(!coors.count(p1)){
            dp[dir][ind] = 1;
            res[dir][ind] = p1;
            return 1;
        }
        int x2 = x + dx, y2 = y;
        pair<int, int> p2 = make_pair(x2, y2);
        if(!coors.count(p2)){
            dp[dir][ind] = 1;
            res[dir][ind] = p2;
            return 1;
        }
        int shy = calc(x1, y1, dir, dx, dy);
        int shx = calc(x2, y2, dir, dx, dy);
        if(shy <= shx){
            dp[dir][ind] = shy + 1;
            res[dir][ind] = res[dir][coors[p1]];
            return dp[dir][ind];
        }
        else{
            dp[dir][ind] = shx + 1;
            res[dir][ind] = res[dir][coors[p2]];
            return dp[dir][ind];
        }
    }
}

int main(){
    int n;
    cin >> n;
    int arr[n][2];
    for(int i = 0; i < n; i++){
        int x, y;  
        cin >> x >> y;
        arr[i][0] = x; arr[i][1] = y;
        pair<int, int> p = make_pair(x, y);
        coors[p] = i;
        for(int dir = 0; dir < 4; dir++){
            dp[dir][i] = -1;
        }
    }
    for(int i = 0; i < n; i++){
        int x = arr[i][0], y = arr[i][1];
        int min = N+1;
        pair<int, int> resp;
        // NE
        int a = calc(x, y, 0, 1, 1);
        if(a < min){
            resp = res[0][i];
            min = a;
        }
        // SE
        int b = calc(x, y, 1, 1, -1);
        if(b < min){
            resp = res[1][i];
            min = b;
        }
        // SW
        int c = calc(x, y, 2, -1, -1);
        if(c < min){
            resp = res[2][i];
            min = c;
        }
        // SW
        int d = calc(x, y, 3, -1, 1);
        if(d < min){
            resp = res[3][i];
            min = d;
        }
        cout << resp.first << ' ' << resp.second << '\n';
    }


}