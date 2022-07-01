#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

void printarr(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout << arr[i] << ' ';
    }
    cout << endl;
}

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        string s;
        cin >> s;
        int n = s.size();

        int arr[n+1];
        arr[0] = 0;
        for(int i = 0; i < n; i++){
            arr[i+1] = arr[i];
            if(s[i] == '1') arr[i+1]++;
        }

        vector<int> zeros;
        zeros.push_back(-1);
        for(int i = 0; i < n; i++){
            if(s[i] == '0') zeros.push_back(i);
        }

        int a = -1, b = n;
        while(b - a > 1){
            int c = (a + b)/2;
            bool valid = false;
            for(int i = 0; i < zeros.size(); i++){
                int x = arr[zeros[i]+1]; 
                int y;
                if(i + c + 1 >= zeros.size()){
                    y = 0;
                }
                else{
                    y = arr[n] - arr[zeros[i+c+1]];
                }
                // cout << "c: " << c << endl;
                // cout << "i: " << i << endl;
                // cout << "x: " << x << endl;
                // cout << "y: " << y << endl;
                if(x + y <= c) valid = true;
            }

            if(valid) b = c;
            else a = c;
            // cout << "a: " << a << endl;
            // cout << "b: " << b << endl;
        }

        cout << b << '\n';
    }

}