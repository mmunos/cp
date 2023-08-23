#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

void print(int x){
    int p = 100000;
    while(p > x and p > 1){
        cout << ' '; p /= 10;
    }
    cout << x;
}

int main(){
    int N;
    cin >> N;
    vector<int> v(N);
    int sum = 0;
    for(int i = 0; i < N; i++){
        cin >> v[i];
        sum += v[i];
    }
    if(3 * sum % N == 0){
        vector<int> p;
        for(int i = 0; i < N; i++) p.push_back(i);
        do {
            vector<int> a, b;
            for(int i = 0; i < N; i++){
                a.push_back(3 * sum / N - v[i] - v[p[i]]);
                b.push_back(3 * sum / N - v[i] - v[p[i]]);
            }
            sort(a.begin(), a.end());
            bool validid = true;
            for(int i = 0; i < N; i++){
                if(a[i] != v[i]) validid = false;
            }
            if(validid){
                cout << "woot:";
                for(int i = 0; i < N; i++){
                    print(v[i]);
                }
                cout << endl;
                cout << "waat:";
                for(int i = 0; i < N; i++){
                    print(v[p[i]]);
                }
                cout << endl;
                cout << "weet:";
                for(int i = 0; i < N; i++){
                    print(b[i]);
                }
                cout << endl;
                cout << "---------\n";
            }
        } while(next_permutation(p.begin(), p.end()));
    }
    cout << "that is all\n";
}