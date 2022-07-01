#include <iostream>
#include <algorithm>
// #include <vector>
// #include <map>
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
        int n, m;
        cin >> n >> m;
        int arr[n][m];
        int brr[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin >> arr[i][j];
                brr[i][j] = arr[i][j];
            }
            sort(brr[i], brr[i] + m);
        }
        set<int> s[n];
        bool poss = true;
        set<int> ps;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != brr[i][j]){
                    s[i].insert(j);
                    ps.insert(j);
                }
            }
        }
        if(ps.size() == 0){
            cout << "1 1\n";
        }
        else if(ps.size() > 2){
            cout << "-1\n"; 
        }
        else{
            int a = m;
            int b = -1;
            for(int x: ps){
                a = min(a, x); b = max(b, x);
            }
            for(int i = 0; i < n; i++){
                swap(arr[i][a], arr[i][b]);
            }
            bool val = true;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] != brr[i][j]) val = false;
                }
            }
            if(val){
                cout << a + 1 << ' ' << b + 1 << '\n';
            }
            else{
                cout << "-1\n";
            }
        }
    }
}
