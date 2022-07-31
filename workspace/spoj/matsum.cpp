#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <vector>
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

// 0 - indexed / inclusive - inclusive
template <class T>
class FT2D
{
    vector<vector<T> > t;
    int n, m;

public:
    FT2D() {}
    FT2D(int n, int m) : n(n), m(m) { t.assign(n, vector<T>(m, 0)); }

    void add(int r, int c, T value)
    {
        for (int i = r; i < n; i |= i + 1)
            for (int j = c; j < m; j |= j + 1)
                t[i][j] += value;
    }

    T sum(int r, int c)
    {
        T res = 0;
        for (int i = r; i >= 0; i = (i & (i + 1)) - 1)
            for (int j = c; j >= 0; j = (j & (j + 1)) - 1)
                res += t[i][j];
        return res;
    }

    T sum(int r1, int c1, int r2, int c2)
    {
        return sum(r2, c2) - sum(r1 - 1, c2) - sum(r2, c1 - 1) +
               sum(r1 - 1, c1 - 1);
    }

    T get(int r, int c) { return sum(r, c, r, c); }

    void set(int r, int c, T value) { add(r, c, -get(r, c) + value); }
};

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        FT2D<int> ft(n, n);
        string inst;
        while(cin >> inst){
            if(inst == "END") break;
            else if(inst == "SET"){
                int x, y, v;
                cin >> x >> y >> v;
                ft.set(x, y, v);
            }
            else if(inst == "SUM"){
                int x1, y1, x2, y2;
                cin >> x1 >> y1 >> x2 >> y2;
                cout << ft.sum(x1, y1, x2, y2) << '\n';
            }
        }
    }
}