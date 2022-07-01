#include <iostream>
// #include <algorithm>
// #include <vector>
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
    int caso = 1;
    while(T--){
        string s;
        cin >> s;
        int n = s.size();
        string res;
        char c = s[n-1], d = 0;
        res.insert(0, 1, c);
        for(int i = n-2; i >= 0; i--){
            if(s[i] == c){
                if(s[i] < d){
                    res.insert(0, 1, s[i]);
                    res.insert(0, 1, s[i]);
                }
                else{
                    res.insert(0,1, s[i]);
                }
            }
            else{
                if(s[i] < c){
                    res.insert(0,1, s[i]);
                    res.insert(0,1, s[i]);
                }
                else{
                    res.insert(0,1, s[i]);
                }
                d = c; c = s[i];
            }
        }
        cout << "Case #" << caso++ << ": " << res << '\n';
    }
}