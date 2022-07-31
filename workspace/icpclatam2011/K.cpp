#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
#include <algorithm>
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

int cmp(int a[3], int b[3]){
    if(a[0] == a[2]){
        if(b[0] == b[2]){
            return a[0] - b[0];
        }
        else return 1;
    }
    else if(a[1] == a[2]){
        if(b[0] == b[2]){
            return -1;
        }
        else if(b[1] == b[2]){
            if(b[1] == a[1]){
                return a[0] - b[0];
            }
            else return a[1] - b[1];
        }
        else if(b[0] == b[1]){
            if(a[1] == b[0]){
                return a[0] - b[2];
            }
            else return a[1] - b[0];
        }
        else return 1;
    }
    else if(a[0] == a[1]){
        if(b[0] == b[2]){
            return -1;
        }
        else if(b[1] == b[2]){
            if(b[1] == a[0]){
                return a[2] - b[0];
            }
            else return a[0] - b[1];
        }
        else if(b[0] == b[1]){
            if(a[0] == b[0]){
                return a[2] - b[2];
            }
            else return a[0] - b[0];
        }
        else return 1;
    }
    else{
        if(b[0] == b[1] or b[1] == b[2]) return -1;
        else return 0;   
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int a[3];
    while(cin >> a[0] >> a[1] >> a[2]){
        if(a[0] == 0) break;
        sort(a, a + 3);
        int b[3];
        int res[3] = {14,14,14};
        for(b[0] = 1; b[0] <= 13; b[0]++){
            for(b[1] = b[0]; b[1] <= 13; b[1]++){
                for(b[2] = b[1]; b[2] <= 13; b[2]++){
                    // cout << b[0] << ' ' << b[1] << ' ' << b[2] << '\n';
                    // cout << cmp(a, b) << '\n';
                    // cout << cmp(b, res) << '\n';
                    if(cmp(a, b) < 0 and cmp(b, res) < 0){
                        res[0] = b[0]; res[1] = b[1]; res[2] = b[2];
                    }
                }
            }
        }
        if(res[0] == 14) cout << "*\n";
        else cout << res[0] << ' ' << res[1] << ' ' << res[2] << '\n';
    }
}