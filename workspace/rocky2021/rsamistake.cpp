#include <iostream>
using namespace std;

typedef long long int ll;

ll gcd(ll a, ll b){
    if(a < b) return gcd(b, a);
    else if(b == 0) return a;
    else return gcd(b, a % b);
}



int main(){
    ll a, b;
    cin >> a >> b;
    if(gcd(a, b) != 1){
        cout << "no credit"; return 0;
    }
    ll aux = a;
    bool valid = true;
    for(ll d = 2; d * d <= a; d++){
        if(aux % d == 0){
            aux /= d;
            if(aux % d == 0) valid = false;
        }
    }
    ll bux = b;
    bool walid = true;
    for(ll d = 2; d * d <= b; d++){
        if(bux % d == 0){
            bux /= d;
            if(bux % d == 0) valid = false;
        }
    }
    if(aux == a and bux == b){
        cout << "full credit\n";
    }
    else if(valid){
        cout << "partial credit\n";
    }
    else {
        cout << "no credit\n";
    }
}