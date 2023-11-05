#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <set>
#include <map>
#include <random>
#include <chrono>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

int main(){
    ll k = 6;
    ll N = 1;
    for(int i = 0; i < k; i++) N *= k;
    set<string> seqs;
    for(ll mask = 0; mask < N; mask++){
        int arr[k];
        ll auxmask = mask;
        for(int i = 0; i < k; i++){
            arr[k-i-1] = auxmask % k; auxmask /= k;
        }
        //check
        set<int> vals;
        bool valid = true;
        for(int i = 0; i < k; i++){
            if(arr[i] > vals.size()) {valid = false; break;}
            vals.insert(arr[i]);
        }
        if(valid){
            string s;
            for(int a: arr) s += ('0' + a);
            string t(s);
            reverse(t.begin(), t.end());
            int curr = 0;
            for(int i = 0; i < k; i++){
                int d = t[i] - '0';
                if(d >= curr){
                    //swap all currs and s[i]'s
                    for(int j = 0; j < k; j++){
                        if(t[j] - '0' == d){
                            t[j] = '0' + curr;
                        }
                        else if(t[j] - '0' == curr){
                            t[j] = '0' + d;
                        }
                    }
                    curr++;
                }
            }
            // cout << s << ' ' << t << endl;
            if(!seqs.count(t)) {
                seqs.insert(s);
                if(seqs.size() % 100000 == 0){
                    cerr << "curr size :" << seqs.size() << endl;
                }
            }
        }
        if(mask % 10000000 == 0){
            cerr << "mask " << mask << ": " << seqs.size() << " in\n";
        }
    }
    cout << seqs.size() << endl;
    for(string s: seqs){
        cout << s.size() << '\n';
        for(char c: s){
            cout << ++c << ' ';
        }
        cout << '\n';
    }
}