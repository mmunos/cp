#include <iostream>
#include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>

using namespace std;

typedef long long int ll;

int popcount(int x){
    int res = 0;
    while(x > 0){
        if(x & 1) res++;
        x >>= 1;
    }
    return res;
}

string show(int x){
    stringstream ss;
    for(int i = 7; i >= 0; i--){
        if(x & (1 << i)) ss << '1';
        else ss << '0';
    }
    return ss.str();
}

int main(){
    vector<int> vals[9];
    for(int x = 0; x < (1<<8); x++){
        int p = popcount(x);
        vals[p].push_back(x);
    }

    // for(int i = 0; i < 8; i++){
    //     cout << i << '\n';
    //     for(int x: vals[i]){
    //         cout << show(x) << ' ';
    //     }
    //     cout << '\n';
    // }
    int T;
    cin >> T;
    while(T--){
        string allones = "11111111";
        cout << allones << '\n';
        int res;
        cin >> res;
        if(res < 0) return 0;
        int ps[9];
        for(int i = 0; i <= 8; i++){
            ps[i] = 0;
        }
        while(res != 0){
            cout << show(vals[res][ps[res]]) << '\n';
            ps[res]++; if(ps[res] >= vals[res].size()) ps[res] = 0;
            cin >> res;
            if(res < 0) return 0;
        }
    }
    return 0;

}