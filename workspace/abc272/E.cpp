#include <bits/stdc++.h>
using namespace std;

#define ll long long
// #define pii pair<ll, int>
// #define pq priority_queue <pii, vector<pii>, greater<pii>>

struct SA {
    int n; vector<int> C, R, R_, sa, sa_, lcp;
    inline int gr(int i) { return i < n ? R[i] : 0; }
    void csort(int maxv, int k) {
        C.assign(maxv + 1, 0); for(int i = 0; i < n; i++) C[gr(i + k)]++;
        for(int i = 1; i <= maxv; i++) C[i] += C[i - 1];
        for(int i = n - 1; i >= 0; i--) sa_[--C[gr(sa[i] + k)]] = sa[i];
        sa.swap(sa_);
    }
    void getSA(string s) {
        R = R_ = sa = sa_ = vector<int>(n); for(int i = 0; i < n; i++) sa[i] = i;
        sort(sa.begin(), sa.end(), [&s](int i, int j) { return s[i] < s[j]; });
        int r = R[sa[0]] = 1;
        for(int i = 1; i < n; i++) R[sa[i]] = (s[sa[i]] != s[sa[i - 1]]) ? ++r : r;
        for(int h = 1; h < n && r < n; h <<= 1) {
            csort(r, h); csort(r, 0); r = R_[sa[0]] = 1;
            for(int i = 1; i < n; i++) {
                if (R[sa[i]] != R[sa[i - 1]] || gr(sa[i] + h) != gr(sa[i - 1] + h)) r++;
                R_[sa[i]] = r;
            } 
            R.swap(R_);
        }
    }
    void getLCP(string &s) {
        lcp.assign(n, 0); int k = 0;
        for(int i = 0; i < n; i++){
            int r = R[i] - 1;
            if (r == n - 1) { k = 0; continue; }
            int j = sa[r + 1];
            while (i + k < n && j + k < n and s[i + k] == s[j + k]) k++;
            lcp[r] = k; if (k) k--;
        }
    }
    SA(string &s) { n = s.size(); getSA(s); getLCP(s); }
};

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); 
    int n;
    cin >> n;
    string s, t;
    cin >> s >> t;
    string st = s + s + "$" + t + t + "~";
    SA sa(st);
    ll curr = 0, res = 0;
    for(int i = 0; i < st.size(); i++){
        if(sa.sa[i] < n) curr++;
        else if(sa.sa[i] >= 2*n + 1 and sa.sa[i] < 3*n + 1) res += curr;
    }
    cout << res << '\n';
}