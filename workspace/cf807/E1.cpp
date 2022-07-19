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

struct ST{
    vector<int> _val, _l, _r, _left, _right, _lazy;
    int n, _t;
    ST(vector<int> &arr, int n) : n(n) {
        _t = 0;
        for(int i = 0; i < 2*n; i++){
            _val.push_back(0);
            _l.push_back(0);
            _r.push_back(0);
            _left.push_back(0);
            _right.push_back(0);
            _lazy.push_back(0);
        }
        _t = build(arr, 0, n-1);
        // cout << _t << endl;
    }
    int build(vector<int> &arr, int l, int r){
        // cout << "l: " << l << " r: " << r << endl;
        if(l == r){
            // cout << arr[l] << endl;
            // cout << _t << endl;
            _val[_t] = arr[l];
            // cout << "woo" << endl;
            _l[_t] = l, _r[_t] = r, _left[_t] = -1, _right[_t] = -1;
            return _t++;
        }
        else{
            int m = (l + r)/2;
            int _leftp = build(arr, l, m);
            int _rightp = build(arr, m+1, r);
            _val[_t] = _val[_leftp] + _val[_rightp];
            _l[_t] = l, _r[_t] = r, _left[_t] = _leftp, _right[_t] = _rightp;
            // cout << "t: " << _t << " - " << _l[_t] << ' ' << _r[_t] << endl;
            return _t++;
        }
    }
    void update(int p, int delta){
        int t = _t;
        while(_l[t] < _r[t]){
            _val[t] += delta;
            int m = (_l[t] + _r[t])/2;
            if(p <= m) t = _left[t];
            else t = _right[t];
        }
        _val[t] += delta;
    }
    int calc(int t){
        return _val[t] + (_r[t] - _l[t] + 1) * _lazy[t];
    }
    void update(int t, int a, int b, int delta){
        if(a > _r[t] or b < _l[t]) return;
        else if(a <= _l[t] and _r[t] <= b) _lazy[t] += delta;
        else {
            update(_left[t], a, b, delta), update(_right[t], a, b, delta);
            _val[t] = calc(_left[t]) + calc(_right[t]);
        }
    }
    void update(int a, int b, int delta){
        update(_t, a, b, delta);
    }
    int query(int t, int a, int b){
        // cout << "t: " << t << " a: " << a << " b: " << b << endl;
        // cout << _l[t] << ' ' << _r[t] << endl;
        if(a > _r[t] or b < _l[t]) return 0;
        else if(a <= _l[t] and _r[t] <= b) {
            // cout << _val[t] << " + " << (_r[t] - _l[t] + 1) << " * " << _lazy[t] << endl; 
            return _val[t] + (_r[t] - _l[t] + 1) * _lazy[t];
        }
        else {
            _lazy[_left[t]] += _lazy[t], _lazy[_right[t]] += _lazy[t], _lazy[t] = 0;
            _val[t] = calc(_left[t]) + calc(_right[t]);
            return query(_left[t], a, b) + query(_right[t], a, b);
        }
    }
    int query(int a, int b){
        return query(_t, a, b);
    }

    int select(int k){
        int t = _t;
        if(k > calc(t)) return n;
        while(_l[t] < _r[t]){
            // cout << _l[t] << " - " << _r[t] << ": " << calc(t) << " k: " << k << endl;
            _lazy[_left[t]] += _lazy[t], _lazy[_right[t]] += _lazy[t], _lazy[t] = 0;
            _val[t] = calc(_left[t]) + calc(_right[t]);
            // cout << "vals: " << calc(_left[t]) << ' ' << calc(_right[t]) << endl;
            if(k <= calc(_left[t])) t = _left[t];
            else {k -= calc(_left[t]), t = _right[t];}
        }
        return _l[t];
    }
    int select_0(int k){
        int t = _t;
        if(k > n - calc(t)) return n;
        while(_l[t] < _r[t]){
            // cout << _l[t] << " - " << _r[t] << ": " << calc(t) << " k: " << k </< endl;
            _lazy[_left[t]] += _lazy[t], _lazy[_right[t]] += _lazy[t], _lazy[t] = 0;
            _val[t] = calc(_left[t]) + calc(_right[t]);
            if(k <= _r[_left[t]]-_l[t]+1-calc(_left[t])) t = _left[t];
            else {k -= _r[_left[t]]-_l[t]+1-calc(_left[t]), t = _right[t];}
        }
        return _l[t];
    }
};

void print(ST& st){
    for(int i = 0; i < 12; i++){
        cout << st.query(i, i) << ' ';
    }
    cout << endl;
}


const int N = 200100;

int main(){
    // ios_base::sync_with_stdio(false); cin.tie(NULL);
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
    vector<int> v;
    for(int i = 0; i < N; i++){
        v.push_back(arr[i]);
    }
    ST st(v, N);
    // cout << "hey" << endl;

                // print(st);

    // for(int i = 1; i <= n; i++){
    //     cout << i << "-th zero " << st.select_0(i) << endl;
    // }
    // for(int i = 1; i <= n; i++){
    //     cout << i << "-th one " << st.select(i) << endl;
    // }
    while(q--){
        int k, ell;
        cin >> k >> ell;
        //remove vals[k-1]
        if(st.query(vals[k-1], vals[k-1]) > 0){
            st.update(vals[k-1], vals[k-1], -1);
        }
        else{   
            int count_ones = st.query(0, vals[k-1]);
            int pos_next_1_to_the_right = st.select(count_ones + 1);
            st.update(pos_next_1_to_the_right, pos_next_1_to_the_right, -1);
            st.update(vals[k-1], pos_next_1_to_the_right - 1, 1);
        }

                        // print(st);

        vals[k-1] = ell;
        //put vals[k-1];
        if(st.query(vals[k-1], vals[k-1]) == 0){
            st.update(vals[k-1], vals[k-1], 1);
        }
        else{
            int count_zeros = vals[k-1]+1 - st.query(0, vals[k-1]);
            int pos_next_0_to_the_right = st.select_0(count_zeros + 1);
            st.update(pos_next_0_to_the_right, pos_next_0_to_the_right, 1);
            st.update(vals[k-1], pos_next_0_to_the_right - 1, -1);
        }

                        // print(st);

        //get max pos 1
        int tot_ones = st.query(0, N-1);
        // cout << "tot_ones " << tot_ones << endl;
        int pos_last_1 = st.select(tot_ones);
        cout << pos_last_1 << '\n';
    }
}