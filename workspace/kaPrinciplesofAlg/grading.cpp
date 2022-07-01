#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    ll sc[5];
    for(int i = 0; i < 5; i++){
        cin >> sc[i];
    }
    
    ll val;
    cin >> val;

    for(int i = 0; i < 5; i++){
        if(val >= sc[i]){
            cout << (char)(i+'A') << endl;
            return 0;
        }
    }
    
    cout << 'F' << endl;
    return 0;
}