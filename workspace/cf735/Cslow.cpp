#include <iostream>
#include <algorithm> 
using namespace std;

#define ll long long

int mex(int n, int m){
    bool c[m+2];
    for(int i = 0; i <= m+1; i++){
        c[i] = false;
    }
    for(int i = 0; i <= m; i++){
        if((i ^ n) >= 0 && (i ^ n) <= m){
            c[i ^ n] = true;
        }
    }
    for(int i = 0; i <= m+1; i++){
        if(!c[i]) return i;
    }
    return -1;
}

int main(){
    for(int n = 0; n <= 100; n++){
        for(int m = 0; m <= 100; m++){
            cout << n << ", " << m << ": " << mex(n, m) << " " << m-n << " " << (n ^ m) << '\n';
        }
    }
}

