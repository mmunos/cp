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
        int ones = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '1') ones++;
        }
        if(ones == 0 or ones % 2 == 1){
            cout << "NO\n";
        }
        else{
            cout << "YES\n";
            int a = 0;
            while(s[a] != '1') a++;
            //a is first 1 
            a++;
            vector<pair<int, int> > res;
            bool prevwasone = true;
            for(int i = 0; i < n; i++){
                if(prevwasone){
                    res.push_back(make_pair(-1, (i+a)%n));
                    if(s[(i+a)%n] == '0') prevwasone = false;
                }
                else{
                    res.push_back(make_pair((i+a-1)%n, (i+a)%n));
                    if(s[(i+a)%n] == '1') prevwasone = true;
                }
            }
            int pivot = res[0].second;
            for(int i = 1; i < n; i++){
                int u = res[i].first;
                int v = res[i].second;
                if(u < 0) u = pivot;
                cout << (u+1) << ' ' << (v+1) << '\n';
            }
        }
    }
}
