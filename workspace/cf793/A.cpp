#include <iostream>
#include <algorithm>
#include <queue>
#include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>


using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        string s;
        cin >> s;
        int k = n/2;
        int res = 1;
        for(int i = k+1; i < n; i++){
            if(s[i] == s[k]) res++;
            else break;
        }
        for(int i = k-1; i >= 0; i--){
            if(s[i] == s[k]) res++;
            else break;
        }
        cout << res << '\n';
    }
}
