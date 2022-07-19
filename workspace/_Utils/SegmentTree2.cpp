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
// #include <functional>

using namespace std;

#define ll long long

//slow -- do not use

struct ST{
    vector<int> _val, _l, _r, _left, _right;
    int _t;
    ST(vector<int> &arr, int n){
        _t = 0;
        _val.reserve(2*n);
        _l.reserve(2*n);
        _r.reserve(2*n);
        _left.reserve(2*n);
        _right.reserve(2*n);
        _t = build(arr, 0, n-1);
        cout << _t << endl;
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
    int query(int t, int a, int b){
        // cout << "a: " << a << " b: " << b << endl;
        // cout << _r[t] << ' ' << _l[t] << endl;
        if(a > _r[t] or b < _l[t]) return 0;
        else if(a <= _l[t] and _r[t] <= b) return _val[t];
        else return query(_left[t], a, b) + query(_right[t], a, b);
    }
    int query(int a, int b){
        return query(_t, a, b);
    }
};

int main(){
    vector<int> v = {7, 9, 3, 2, 6, 8, 4, 2, 1};
    int n = v.size();
    vector<int> _v;
    for(int i = 0; i < n; i++){
        _v.push_back(v[i]);
    }
    ST st(_v, 9);
    cout << "succ" << endl;
    cout << st.query(4, 5) << endl;
    cout << st.query(2, 8) << endl;
    cout << st.query(3, 7) << endl;
    st.update(4, 7);
    cout << st.query(3, 7) << endl;
    
}