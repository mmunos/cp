#pragma GCC optimize("Ofast")
#pragma GCC target("bmi,bmi2,lzcnt,popcnt")
#pragma GCC target("avx,avx2,f16c,fma,sse3,ssse3,sse4.1,sse4.2") 

#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long
#define INF 1e9

struct Node
{
    int v, lmnz, rmnz;
    int lazy = 0;
    Node() { v = 0; lmnz = INF; rmnz = -1;} // neutro
    Node(int v, int ind) : v(v), lmnz(v == 0 ? INF : ind), rmnz(v == 0 ? -1 : ind) {}
    Node(const Node &a, const Node &b) { 
        v = a.v + b.v;
        lmnz = min(a.lmnz, b.lmnz);
        rmnz = max(a.rmnz, b.rmnz);
    }
};

// 0 - indexed / inclusive - exclusive
template <class node>
struct STL
{
    vector<node> t; int n;

    STL(vector<node> &arr, int N) : n(N), t(N * 2)
    {
        copy(arr.begin(), arr.end(), t.begin() + n);
        for (int i = n - 1; i > 0; --i) t[i] = node(t[i << 1], t[i << 1 | 1]);
    }
    void set(int p, const node &value)
    {
        for (t[p += n] = value; p >>= 1;)
            t[p] = node(t[p << 1], t[p << 1 | 1]);
    }
    void update(int p, int delta){
        int val = query(p, p+1).v;
        set(p, Node(val + delta, p));
    }
    node query(int l, int r)
    {
        node ansl, ansr;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1)
        {
            if (l & 1) ansl = node(ansl, t[l++]);
            if (r & 1) ansr = node(t[--r], ansr);
        }
        return node(ansl, ansr);
    }
};

const int N = 200100;

void print(STL<Node> st){
    // for(int i = 0; i < 10; i++){
    //     cout << st.query(i, i+1).v << ' ';
    // }
    // cout << endl;
    for(int i = 0; i < 10; i++){
        cout << st.query(0, i+1).v << ' ';
    }
    cout << endl;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, q;
    cin >> n >> q;
    int vals[n];
    int arr[N];
    for(int i = 0; i < N; i++){
        arr[i] = 0;
    }
    for(int i = 0; i < n; i++){
        cin >> vals[i];
        arr[vals[i]]++;
    }
    for(int i = 0; i < N-1; i++){
        arr[i+1] += arr[i] / 2;
        arr[i] = arr[i] % 2;
    }
    vector<Node> v;
    for(int i = 0; i < N; i++){
        if(i == 0) v.emplace_back(arr[0], 0);
        else v.emplace_back(arr[i] - arr[i-1], i);
    }
    STL<Node> st(v, N);

            // print(st);

    while(q--){
        int k, ell;
        cin >> k >> ell;
        //remove vals[k-1]
        if(st.query(0, vals[k-1]+1).v > 0){
            st.update(vals[k-1], -1); st.update(vals[k-1]+1, 1);
        }
        else{
            int pone = st.query(vals[k-1]+1, N).lmnz;
            st.update(pone, -1); st.update(pone+1, 1);
            st.update(vals[k-1], 1); st.update(pone, -1);
        }

            // print(st);

        vals[k-1] = ell;
        //put vals[k-1];
        if(st.query(0, vals[k-1]+1).v == 0){
            st.update(vals[k-1], 1); st.update(vals[k-1]+1, -1);
        }
        else{
            int pmone = st.query(vals[k-1]+1, N).lmnz;
            // cout << "pmone: " << pmone << endl;
            st.update(vals[k-1], -1); st.update(pmone, 1);
            st.update(pmone, 1); st.update(pmone+1, -1);
        }

            // print(st);

        cout << st.query(0, N).rmnz-1 << '\n';
    }
}