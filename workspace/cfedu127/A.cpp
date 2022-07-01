#include <iostream>
// #include <algorithm>
// #include <vector>
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
        string s;
        cin >> s;
        int c = 1;
        bool yes = true;
        for(int i = 1; i < s.size(); i++){
            if(s[i] != s[i-1]){
                if(c == 1) yes = false;
                c = 1;
            }
            else c++;
        }
        if(yes and c != 1) cout << "YES\n";
        else cout << "NO\n";
    }


}