#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

void print(int x){
    int p = 100000;
    while(p > x and p > 1){
        cout << " "; p /= 10;
    }
    cout << x;
}

int main(){
    int N = 9;
    int reps = 1000000;
    srand (time(NULL));
    for(int iter = 0; iter < reps; iter++){
        ll v[N]; v[0] = 0;
        for(int i = 1; i < N; i++){
            v[i] = rand() % 100;
        }
        sort(v, v+N);
        ll sum = v[0];
        for(int i = 1; i < N; i++){
            sum += v[i];
        }
        bool valid = true;
        if(3 * sum % N != 0) valid = false;
        set<int> vals;
        for(int i = 0; i < N; i++){
            vals.insert(v[i]);
        }
        if(valid){
            // for(int i = 0; i < N; i++){
            //     cout << v[i] << ' ';
            // }
            // cout << endl;
            int p[N];
            for(int i = 0; i < N; i++) p[i] = i;
            int countsols = 0;
            do {
                vector<int> a, b;
                bool yes = true;
                // for(int i = 0; i < N; i++){
                //     cout << p[i] << ' ';
                // }
                // cout << endl;
                set<int> bs;
                for(int i = 0; i < N; i++){
                    int val = 3 * sum / N - v[i] - v[p[i]];
                    b.push_back(val);
                    bs.insert(val);
                    if(!vals.count(val)){
                        sort(p+i+1, p+N, greater<int>()); yes = false; break;
                    }
                }
                // for(int i = 0; i < N; i++){
                //     cout << p[i] << " ";
                // }
                // cout << "b";
                // cout << endl;
                if(yes and bs.size() == N){
                    countsols++;
                    // cout << "woo" << endl;
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
                    cout << '\n';
                    cout << "---------";
                    cout << endl;
                }
            } while(next_permutation(p,  p + N));
            // cout << "---------";
            // cout << endl;
            if(countsols > 8){
                cout << "heyhey" << endl;
            }
        }
    }

}