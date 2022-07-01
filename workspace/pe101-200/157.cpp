#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
#include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
#include <numeric>


using namespace std;

typedef long long int ll;

unordered_map<int, int> sigma;

int countdivs(int x){
    if(sigma.count(x)) return sigma[x];
    for(int d = 2; d * d <= x; d++){
        if(x % d == 0){ //d is prime
            int c = 0;
            while(x % d == 0){
                x /= d; c++;
            }
            return (c+1) * countdivs(x);
        }
    }
    return sigma[x] = 2;
}

int countdivsslow(int x){
    if(x == 1) return 1;
    int res = 2;
    for(int d = 2; d*d <= x; d++){
        if(d * d == x) res++;
        else if(x % d == 0) res += 2;
    }
    return res;
}

ll calc(int n){
    set<int> divs;
    for(int i = 1; i*i <= n; i++){
        if(n % i == 0){
            divs.insert(i);
            divs.insert(n/i);
        }
    }
    ll res = 0;
    for(int x: divs){
        for(int y: divs){
            if(x > y) continue;
            if(std::gcd(x, y) > 1) continue;
            int val = n/x + n/y;
            res += countdivsslow(val);
        }
    }   
    return res;
}

int main(){
    sigma[1] = 1;
    int arr[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    ll tot = 0;
    for(int n: arr){
        ll val = calc(n);
        cout << n << ": " << val << endl;
        tot += val;
    }
    cout << tot << endl;

}
