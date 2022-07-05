#include <iostream>
// #include <algorithm>
// #include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n;
    while(cin >> n){
        if(n % 6 == 0){
            cout << "Y\n";
        }
        else{
            cout << "N\n";
        }
    }
}