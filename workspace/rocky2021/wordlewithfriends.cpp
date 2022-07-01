#include <iostream>
using namespace std;

string compare(string t, string s){
    string res = "-----";
    for(int i = 0; i < 5; i++){
        if(t[i] == s[i]){
            res[i] = 'G';
            s[i] = '-';
        }
    }
    for(int i = 0; i < 5; i++){
        if(res[i] == '-'){
            for(int j = 0; j < 5; j++){
                if(t[i] == s[j]){
                    s[j] = '-';
                    res[i] = 'Y';
                    break;
                }
            }
        }
    }
    return res;
}


int main(){
    int n, m;
    cin >> n >> m;
    string arr[n];
    string code[n];
    string brr[m];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        cin >> code[i];
    }
    for(int i = 0; i < m; i++){
        cin >> brr[i];
    }
    for(int i = 0; i < m; i++){
        bool valid = true;
        for(int j = 0; j < n; j++){
            // cout << arr[j] << ' ' << brr[i] << ": ";
            // string c = compare(arr[j], brr[i]);
            // cout << c << endl;
            if(compare(arr[j], brr[i]) != code[j]) valid = false;
        }
        if(valid){
            cout << brr[i] << endl;
        }
    }


}