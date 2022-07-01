#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <algorithm> 
using namespace std;

typedef long long int ll;

template<class t> class SegTreeLazy {
    vector<ll> *arr, st, lazy; int n;

    void build(int u, int i, int j) {
        if (i == j) {
            st[u] = (*arr)[i];
            return;
        }
        int m = (i+j)/2, l = u*2+1, r = u*2+2;
        build(l, i, m);
        build(r, m+1, j);
        st[u] = t::merge_op(st[l], st[r]);
    }

    void propagate(int u, int i, int j, ll x) {
        st[u] = t::range_op(st[u], i, j, x);
        if (i != j) {
            lazy[u*2+1] = t::prop_op(lazy[u*2+1], x);
            lazy[u*2+2] = t::prop_op(lazy[u*2+2], x);
        }
        lazy[u] = 0;
    }

    ll query(int a, int b, int u, int i, int j) {
        if (j < a or b < i) return t::neutro;
        if (lazy[u]) propagate(u, i, j, lazy[u]);
        if (a <= i and j <= b) return st[u];
        int m = (i+j)/2, l = u*2+1, r = u*2+2;
        ll x = query(a, b, l, i, m);
        ll y = query(a, b, r, m+1, j);
        return t::merge_op(x, y);
    }

    void update(int a, int b, ll value, int u, int i, int j) {
        if (lazy[u]) propagate(u, i, j, lazy[u]);
        if (a <= i and j <= b) propagate(u, i, j, value);
        else if (j < a or b < i) return;
        else {
            int m = (i+j)/2, l = u*2+1, r = u*2+2;
            update(a, b, value, l, i, m);
            update(a, b, value, r, m+1, j);
            st[u] = t::merge_op(st[l], st[r]);
        }
    }

public:
    SegTreeLazy(vector<ll>& v) {
        arr = &v;
        n = v.size();
        st.resize(n*4+5);
        lazy.assign(n*4+5, 0);
        build(0, 0, n-1);
    }

    ll query(int a, int b) {
        return query(a, b, 0, 0, n-1);
    }

    void update(int a, int b, ll value) {
        update(a, b, value, 0, 0, n-1);
    }
};

struct RSQ { // range sum query
    static ll const neutro = 0;
    static ll merge_op(ll x, ll y) { return x + y; }
    static ll range_op(ll st_u, int i, int j, ll x) { return st_u + (j - i + 1) * x; }
    static ll prop_op(ll child, ll x) { return child + x; }
};

struct RMinQ { // range minimum query
    static ll const neutro = LLONG_MAX;
    static ll merge_op(ll x, ll y) { return min(x, y); }
    static ll range_op(ll st_u, int a, int b, ll x) { return st_u + x; }
    static ll prop_op(ll child, ll x) { return child + x; }
};

struct RMaxQ { // range maximum query
    static ll const neutro = LLONG_MIN;
    static ll merge_op(ll x, ll y) { return max(x, y); }
    static ll range_op(ll st_u, int a, int b, ll x) { return st_u + x; }
    static ll prop_op(ll child, ll x) { return child + x; }
};

int main(){
    int n, m;
    cin >> n >> m;
    vector< vector< pair<int, int> > > ranges;
    set<int> vals;
    for(int i = 0; i <= n; i++){
        vector< pair<int, int> > vec;
        ranges.push_back(vec);
    }
    for(int i = 0; i < m; i++){
        int ind, l, r;
        cin >> ind >> l >> r;
        vals.insert(l); vals.insert(r);
        pair<int, int> p = make_pair(l, r);
        ranges[ind].push_back(p);
    }
    map<int, int> encode;
    map<int, int> decode;
    int k = 0;
    for(int v: vals){
        encode[v] = k;
        decode[k] = v; k++;
    }
    vector<ll> arrmax(k+1); 
    SegTreeLazy<RMaxQ> stmax(arrmax);
    vector<ll> arrind(k+1);
    SegTreeLazy<RMaxQ> stind(arrind);
    int last[n+1];
    int maxres = -1;
    int lastind = 0;
    for(int ind = 1; ind <= n; ind++){
        pair<int, int> maxp;
        int maxv = -1;
        for(pair<int, int> p: ranges[ind]){
            int l = encode[p.first], r = encode[p.second];
            int currv = stmax.query(l, r);
            if(currv > maxv){
                maxv = currv; maxp = p;
            }
        }
        int l = encode[maxp.first], r = encode[maxp.second];
        int a = l-1, b = r;
        while(b - a > 1){
            int c = (a+b)/2;
            if(stmax.query(l, c) == maxv) b = c;
            else a = c;
        }
        cout << "b: " << b << endl;
        last[ind] = stind.query(b, b);
        cout << "l: " << last[ind] << endl;
        if(maxv > maxres){
            maxres = maxv+1;
            lastind = ind;
        }

        for(pair<int, int> p: ranges[ind]){
            int l = encode[p.first], r = encode[p.second];
            stmax.update(l, r, maxv+1);
            stind.update(l, r, ind);
        }
    }
    
        cout << lastind << endl;
    bool kill[n];
    for(int i = 0; i <= n; i++){
        kill[i] = true;
    }
    int resv = n;
    while(lastind > 0){
        cout << lastind << endl;
        kill[lastind] = false;
        resv--;
        lastind = last[lastind];
    }
    cout << resv << endl;
    for(int i = 1; i <= n; i++){
        if(kill[i]){
            cout << i;
            if(--resv > 0) cout << ' ';
        }
    }
    cout << endl;
}