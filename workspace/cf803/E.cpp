#include <iostream>
// #include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
// #include <sstream>
// #include <cmath>
// #include <numeric>

using namespace std;

#define ll long long

struct Node
{
    int v;
    Node() { v = 0; } // neutro
    Node(int v) : v(v) {}
    Node(const Node &a, const Node &b) { v = a.v + b.v; }
};

// 0 - indexed / inclusive - exclusive
template <class node>
struct ST
{
    vector<node> t; int n;

    ST(vector<node> &arr, int N) : n(N), t(N * 2)
    {
        copy(arr.begin(), arr.end(), t.begin() + n);
        for (int i = n - 1; i > 0; --i) t[i] = node(t[i << 1], t[i << 1 | 1]);
    }
    void set(int p, const node &value)
    {
        for (t[p += n] = value; p >>= 1;)
            t[p] = node(t[p << 1], t[p << 1 | 1]);
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
ll mod = 998244353;

int main(){
    int T;
    cin >> T;
    while(T--){
        int n, k;
        cin >> n >> k;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        int crr[n+1];
        int pos[n+1];
        // cout << "hello" << endl;
        for(int i = 0; i < n; i++){
            int b;
            cin >> b;
            crr[arr[i]] = b;
        }
        vector<Node> v;
        v.emplace_back(0);
        set<int> onespos;
        for(int i = 1; i <= n; i++){
            pos[i] = -1;
        }
        for(int i = 1; i <= n; i++){
            if(crr[i] < 0) {
                v.emplace_back(1);
                onespos.insert(i);
                // cout << i << ' ';
            }
            else {
                v.emplace_back(0);
                pos[crr[i]] = i;
            }
        }
        // for(int i = 1; i <= n; i++){
        //     cout << pos[i] << ' ';
        // }
        // cout << "\n";
        ST<Node> st(v, n+1);
        // cout << "st:" << endl;
        // for(int i = 0; i <= n; i++){
        //     cout << st.query(i,i+1).v << ' ';
        // }
        // cout << endl;
        // cout << "k " << k << endl;
        ll res = 1;
        for(int i = 1; i <= n; i++){
            if(pos[i] < 0){
                ll ones = st.query(1, min(i+k+1, n+1)).v;
                // cout << "ind " << min(i+k+1, n+1) << endl;
                // cout << "ones " << ones << endl;
                if(ones == 0){
                    res = 0; break;
                }
                else{
                    res *= ones;
                    res %= mod;
                }
                int p = *(--onespos.upper_bound(i + k));
                // cout << "p " << p << endl;
                onespos.erase(p);
                st.set(p, Node(0));
                // cout << "st:" << endl;
                // for(int i = 0; i <= n; i++){
                //     cout << st.query(i,i+1).v << ' ';
                // }
                // cout << endl;
            }
            else{
                if(pos[i] > i + k){
                    res = 0; break;
                }
            }
        }
        cout << res << '\n';
    }

}