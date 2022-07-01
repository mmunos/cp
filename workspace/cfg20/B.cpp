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
        int n = s.size();
        if(s[n-1] == 'A'){
            cout << "NO\n"; continue;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == 'A') count++;
            else count--;
            if(count < 0) break;
        }
        if(count < 0) cout << "NO\n";
        else cout << "YES\n";
    }
}