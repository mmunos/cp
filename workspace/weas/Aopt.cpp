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

vector<int> fib = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169};

int main(){
    int N = 9;
    ll k = 5;
    ll K = 1;
    for(int i = 0; i < N; i++) K *= k;
    cout << K << endl;
    for(ll mask = 0; mask < K; mask++){
        ll v[N];
        ll aux = mask;
        for(int i = 0; i < N; i++){
            v[N-i-1] = aux % k; aux /= k;
        }
        for(int i = 1; i < N; i++){
            v[i] += v[i-1]+1;
        }
        for(int i = 0; i < N; i++){
            v[i] = fib[v[i]];
        }
        bool valid = true;
        ll sum = v[0];
        for(int i = 1; i < N; i++){
            sum += v[i];
        }
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
        }
    }

}