#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
#include <sstream>
// #include <cmath>
// #include <numeric>
// #include <functional>

using namespace std;

#define ll long long

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n;
    cin >> n;
    set<string> s;
    for(int i = 0; i < n; i++){
        string t;
        cin >> t;
        stringstream ss;
        int state = 0;
        for(char c: t){
            if(c == '+'){
                state = 1;
            }
            else if(c == '@'){
                state = 2;
            }
            else{
                if(state == 0){
                    if(c != '.') ss << c;
                }
                else if(state == 1){

                }
                else{
                    ss << c;
                }
            }
        }
        s.insert(ss.str());
    }
    cout << s.size() << '\n';
}