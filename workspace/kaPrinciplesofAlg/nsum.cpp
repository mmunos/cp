#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;
    cin >> n;

    ll sum = 0;

    for(int i = 0; i < n; i++){
        ll a;
        cin >> a;
        sum += a;
    }

    cout << sum << '\n';

    return 0;
}