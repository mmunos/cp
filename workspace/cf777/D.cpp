#include <iostream>
using namespace std;

typedef long long int ll;

ll div(ll x){
    for(ll d = 2; d * d <= x; d++){
        if(x % d == 0) return d;
    }
    return x;
}

int main(){
    int T;
    cin >> T;
    while(T--){
        ll x, d;
        cin >> x >> d;
        if(x % d == 0 && (x/d) % d == 0){
            ll p = div(d); //smallest prime that divides d
            if(p == d){ //d is prime
                while(x % d == 0) x /= d;
                ll q = div(x);
                if(q == 1 or q == x){ //remainder is 1 or prime
                    cout << "NO\n";
                }
                else{
                    cout << "YES\n";
                }
            }
            else{
                ll aux = d;
                int exp = 0;
                while(aux % p == 0) {
                    aux /= p; exp++;
                }
                if(aux == 1 and exp == 2){ //d is prime power with exp 2
                    ll r = x / d / d;
                    ll q = div(r);
                    // cout << "r: " << r << endl;
                    // cout << "q: " << q << endl;
                    if(q == 1 or q == r or (r % p == 0 and (r / p) % p == 0 and r / p / p == p) ){
                        cout << "NO\n";
                    }
                    else{
                        cout << "YES\n";
                    }
                }
                else{ 
                    ll r = x / d / d;
                    ll q = div(r);
                    if(q == 1 or q == r){ 
                        cout << "NO\n";
                    }
                    else{
                        cout << "YES\n";
                    }
                }
            }
        }
        else{
            cout << "NO\n";
        }
    }
}