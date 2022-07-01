#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    ll a, b;
    cin >> a >> b;
    if(b <= 6*a && b >= a){
        cout << 1 << endl;  
    }
    else{
        cout << 0 << endl;
    }
}