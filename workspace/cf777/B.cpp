#include <iostream>
using namespace std;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, m;
        cin >> n >> m;
        char map[n][m];
        for(int i = 0; i < n; i++){
            cin >> map[i];
        }
        if(n == 1 or m == 1){
            cout << "YES\n";
        }
        else {
            bool yes = true;
            for(int i = 0; i < n-1; i++){
                for(int j = 0; j < m-1; j++){
                    int c = 0;
                    for(int u = 0; u <= 1; u++){
                        for(int v = 0; v <= 1; v++){
                            if(map[i+u][j+v] == '1') c++;
                        }
                    }
                    if(c == 3) yes = false;
                }
            }
            if(yes) cout << "YES\n";
            else cout << "NO\n";
        }
    }
}