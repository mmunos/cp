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
    int N = 9;
    ll k = 4;
    ll K = 1;
    for(int i = 0; i < N; i++) K *= k;
    cout << K << endl;
    for(ll mask = 0; mask < K; mask++){
        vector<int> v;
        ll aux = mask;
        for(int i = 0; i < N; i++){
            v.insert(v.begin(), aux % k); aux /= k;
        }
        for(int i = 1; i < N; i++){
            v[i] += v[i-1]+1;
        }
        bool valid = true;
        for(int i = N/3; i < 2*N/3; i++){
            v[i] += 100;
        }
        for(int i = 2*N/3; i < N; i++){
            v[i] += 10000;
        }
        ll sum = v[0];
        for(int i = 1; i < N; i++){
            sum += v[i];
        }
        if(3 * sum % N != 0) valid = false;
        if(valid){
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
                    cout << '\n';
                    cout << "waat:";
                    for(int i = 0; i < N; i++){
                        print(v[p[i]]);
                    }
                    cout << '\n';
                    cout << "weet:";
                    for(int i = 0; i < N; i++){
                        print(b[i]);
                    }
                    cout << '\n';
                    cout << "---------\n";
                }
            } while(next_permutation(p.begin(), p.end()));
        }
    }

}