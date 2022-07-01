#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    ll n;
    cin >> n;
    int count = 1;
    while(n > 1){
        if(n % 2 == 0) n /= 2;
        else n = 3*n+1;
        count++;
    }
    cout << count << '\n';

    return 0;
}