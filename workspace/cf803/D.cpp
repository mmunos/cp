#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    int T;
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        int a = 1, b = n;
        while(b - a > 0){
            int c = (a + b)/2;
            cout << "? " << a << ' ' << c << '\n';
            int count = 0;
            for(int i = 0; i < c - a + 1; i++){
                int x;
                cin >> x;
                if(x >= a and x <= c) count++;
            }
            if(count % 2 == 0){
                a = c+1;
            }
            else{
                b = c;
            }
        }
        cout << "! " << a << '\n';
    }

}