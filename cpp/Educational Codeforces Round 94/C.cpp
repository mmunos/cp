#include <iostream>
using namespace std;

#define ll long long

int main(){
    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        int x;
        cin >> x;
        int n = s.length();
        char res[n];
        for(int i = 0; i < n; i++) res[i] = '1';
        for(int i = 0; i < n; i++){
            if(s[i] == '0'){
                if(i - x >= 0) res[i-x] = '0';
                if(i + x < n) res[i+x] = '0';
            }
        }
        bool valid = true;
        for(int i = 0; i < n; i++){
            if(i - x >= 0 && res[i-x] == '1'){
                if(s[i] == '0') valid = false;
            }
            else if(i + x < n && res[i+x] == '1'){
                if(s[i] == '0') valid = false;
            }
            else{
                if(s[i] == '1') valid = false;
            }
        }
        if(valid){
            for(int i = 0; i < n; i++){
                cout << res[i];
            }
            cout << "\n";
        }
        else{
            cout << "-1\n";
        }
    }
}