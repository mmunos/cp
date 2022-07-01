#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;
ll mod = 998244353;

int main(){
    int T;
    cin >> T;
    int caso = 1;
    while(T--){
        int n, m;
        cin >> n >> m;
        cout << "Case #" << caso++ << ":\n";
        cout << "..";
        for(int j = 1; j < m; j++){
            cout << "+-";
        }
        cout << "+\n";
        cout << "..";
        for(int j = 1; j < m; j++){
            cout << "|.";
        }
        cout << "|\n";
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                cout << "+-";
            }
            cout << "+\n";
            for(int j = 0; j < m; j++){
                cout << "|.";
            }
            cout << "|\n";
        }
        for(int j = 0; j < m; j++){
            cout << "+-";
        }
        cout << "+\n";
    }

}