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
        vector<int> arr;
        bool zero = false;
        set<int> s;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            if(a != 0) arr.push_back(a);
            else zero = true;
            s.insert(a);
        }
        if(zero) arr.push_back(0);
        int m = arr.size();
        if(m > 4){
            cout << "NO\n";
        }
        else{
            bool yes = true;
            for(int i = 0; i < m; i++){
                for(int j = i+1; j < m; j++){
                    for(int k = j+1; k < m; k++){
                        int x = arr[i] + arr[j] + arr[k];
                        if(!s.count(x)) yes = false;
                    }
                }
            }
            if(yes){
                cout << "YES\n";
            }
            else{
                cout << "NO\n";
            }
        }
    }

}