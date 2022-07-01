#include <iostream>
// #include <algorithm>
#include <deque>
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
    int caso = 1;
    while(T--){
        int n;
        cin >> n;
        deque<ll> q;
        for(int i = 0; i < n; i++){
            ll a;
            cin >> a;
            q.push_back(a);
        }
        ll res = 0, last = 0;
        while(!q.empty()){
            ll a = q.front(), b = q.back();
            ll val;
            if(a <= b) {
                q.pop_front();
                val = a;
            }
            else {
                q.pop_back();
                val = b;
            }
            if(val >= last){
                last = val; res++;
            }
        }

        cout << "Case #" << caso++ << ": " << res << '\n';
    }


}