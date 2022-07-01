#include <iostream>
// #include <algorithm>
#include <stack>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
#include <sstream>

using namespace std;

typedef long long int ll;

int main(){
    int T;
    cin >> T;
    while(T--){
        string s, t;
        cin >> s;
        cin >> t;
        stack<char> st1;
        int parityb1 = 0;
        for(char c: s){
            if(c == 'B'){
                parityb1 = (parityb1 + 1) % 2;
            }
            else {
                if(!st1.empty()){
                    if(st1.top() == c){
                        st1.pop();
                    }
                    else{
                        st1.push(c);
                    }
                }
                else{
                    st1.push(c);
                }
            }
        }
        stack<char> st2;
        int parityb2 = 0;
        for(char c: t){
            if(c == 'B'){
                parityb2 = (parityb2 + 1) % 2;
            }
            else {
                if(!st2.empty()){
                    if(st2.top() == c){
                        st2.pop();
                    }
                    else{
                        st2.push(c);
                    }
                }
                else{
                    st2.push(c);
                }
            }
        }
        if(parityb1 == parityb2 and st1.size() == st2.size()){
            if(st1.empty()){
                cout << "YES\n";
            }
            else{
                if(st1.top() == st2.top()){
                    cout << "YES\n";
                }
                else{
                    cout << "NO\n";
                }
            }
        }
        else{
            cout << "NO\n";
        }

    }

}