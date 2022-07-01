#include <iostream>

typedef long long ll;

using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    int s[n], t[m];
    for(int i = 0; i < n; i++){
        cin >> s[i];
    }
    for(int i = 0; i < m; i++){
        cin >> t[i];
    }
    if(s[0] == 1){
        for(int i = 0; i < n; i++){
            s[i] = 1 - s[i];
        }
        for(int i = 0; i < m; i++){
            t[i] = 1 - t[i];
        }
    }
    //s[0] = 0
    bool onlyzeross = true;
    for(int i = 0; i < n; i++){
        if(s[i] == 1) onlyzeross = false;
    }
    if(onlyzeross){
        bool thasaone = false;
        for(int i = 0; i < m; i++){
            if(t[i] == 1) thasaone = true;
        }
        if(thasaone){
            cout << -1 << endl;
            return 0;
        }
    }

    int d1 = n;
    int d0 = 0;
    for(int i = 0; i < n; i++){
        if(s[i] == 1){
            d1 = min(d1, i);
            d1 = min(d1, n-i);
        }
    }
    int res = 0;
    for(int i = 0; i < m; i++){
        if(t[i] == 0){
            if(d0 == 0) res++;
            else{//d0 = 1;
                res += d0;
                d0 = 0; d1 = 1;
                res++;
            }
        }
        else{
            if(d1 == 0) res++;
            else{
                res += d1;
                d1 = 0; d0 = 1;
                res++;
            }
        }
    }
    cout << res << endl;

    return 0;
}