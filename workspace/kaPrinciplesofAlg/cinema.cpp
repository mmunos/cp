#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int lim, n;
    cin >> lim >> n;
    int count = 0;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(a <= lim){
            lim -= a;
        }
        else{
            count++;
        }
    }

    cout << count << '\n';

    return 0;
}