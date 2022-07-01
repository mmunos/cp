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
#include <chrono>
#include <random>

using namespace std;

typedef long long int ll;

int main(){

    mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

    int n;
    cin >> n;
    string s = "aaaaaaaaaa";
    cout << s << '\n';
    n--;
    int p = 0;
    while(n--){
        int next = 0;
        while(next == 0){
            next = rng() % 26;
        }
        s[p] = (s[p] - 'a' + next) % 26 + 'a';
        cout << s << '\n';
        p++;
        if(p >= 10) p = 0;
    }

}