#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;
    cin >> n;

    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        if(i % 2 == 0){
            cout << s << endl;
        }
    }

    return 0;
}