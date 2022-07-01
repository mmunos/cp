#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    string s;
    string t = "WHQESTX";
    int arr[7] = {64, 32, 16, 8, 4, 2, 1};
    while(cin >> s){
        if(s[0] == '*') break;
        int curr = 64;
        int res = -1;
        for(char c: s){
            if(c == '/'){
                if(curr == 64){
                    res++;
                }
                curr = 0;
            }
            else{
                int p = t.find(c);
                curr += arr[p];
            }
        }
        cout << res << '\n';
    }

}