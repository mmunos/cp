#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        vector<ll> res;
        ll x = 1;
        bool valid = true;
        for(int i = 0; i < n; i++){
            if(x > 1000000000) {
                valid = false;
                break;
            }
            res.push_back(x);
            x *= 3;
        }
        if(valid){
            cout << "YES\n";
            for(int i = 0; i < n; i++){
                cout << res[i];
                if(i < n-1) cout << ' ';
                else cout << '\n';
            }
        }
        else{
            cout << "NO\n";
        }
    }

}