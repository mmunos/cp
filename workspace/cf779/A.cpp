#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        string s;
        cin >> s;
        int res = 0;
        for(int i = 0; i < n-1; i++){
            if(s[i] == '0'){
                if(s[i+1] == '0'){
                    res += 2;
                }   
                else{
                    if(i < n-2 and s[i+2] == '0') res++;
                }
            }
        }
        cout << res << '\n';
    }

}