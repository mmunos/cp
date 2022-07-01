#include <iostream>
using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        ll n;
        cin >> n;
        cout << (1 << n) - 1 << endl;
    }

}