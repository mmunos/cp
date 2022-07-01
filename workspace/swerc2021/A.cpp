#include <iostream>
// #include <algorithm>
// #include <queue>
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
        int n;
        cin >> n;
        int maxv[11];
        for(int i = 0; i <= 10; i++){
            maxv[i] = -1;
        }
        for(int i = 0; i < n; i++){
            int a, b;
            cin >> a >> b;
            maxv[b] = max(maxv[b], a);
        }
        int res = 0;
        for(int i = 1; i <= 10; i++){
            if(maxv[i] < 0){
                res = -1; break;
            }
            else{
                res += maxv[i];
            }
        }
        if(res < 0){
            cout << "MOREPROBLEMS\n";
        }
        else{
            cout << res << '\n';
        }
    }

}