#include <iostream>
using namespace std;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, m;
        cin >> n >> m;
        char map[n][m];
        int c = 0;
        for(int i = 0; i < n; i++){
            cin >> map[i];
            for(int j = 0; j < m; j++){
                if(map[i][j] == '1') c++;
            }
        }
        if(map[0][0] == '1'){
            cout << "-1\n";
        }
        else{
            cout << c << '\n';
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m - 1; j >= 1; j--){
                    if(map[i][j] == '1'){
                        cout << i+1 << ' ' << j << ' ' << i+1 << ' ' << j+1 << '\n';
                    } 
                }   
            }
            for (int i = n - 1; i >= 0; i--){
                if(map[i][0] == '1'){
                    cout << i << ' ' << 1 << ' ' << i+1 << ' ' << 1 << '\n';
                }
            }
            
        }
    }
}