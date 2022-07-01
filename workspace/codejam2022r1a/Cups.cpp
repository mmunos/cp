#include <iostream>
#include <algorithm>
#include <vector>
// #include <map>
// #include <unordered_map>
#include <set>
// #include <unordered_set>
#include <sstream>

using namespace std;

typedef long long int ll;

int main(){

    int T;
    cin >> T;
    int caso = 1;
    while(T--){
        int n, w;
        cin >> n >> w;
        int arr[n+1][w];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < w; j++){
                cin >> arr[i][j];
            }
        }
        for(int j = 0; j < w; j++){
            arr[n][j] = 0;
        }
        //start dp
        vector< vector<int> > configs_prev;
        vector<ll> vals_prev;

        vector<int> c0;
        configs_prev.push_back(c0);
        vals_prev.push_back(0);

        for(int i = 0; i < n+1; i++){
            vector<int> ws;
            for(int j = 0; j < w; j++){
                while(arr[i][j]--) ws.push_back(j);
            }
            vector< vector<int> > configs;
            vector<ll> vals;
            do{
                vector<int> c(ws);
                configs.push_back(c);
                vals.push_back(1000000000LL);
            } while(next_permutation(ws.begin(), ws.end()));
            
            for(int i = 0; i < configs_prev.size(); i++){
                for(int j = 0; j < configs.size(); j++){
                    //compare configs
                    int k = 0;
                    vector<int> c_prev = configs_prev[i];
                    vector<int> c_curr = configs[j];
                    while(k < c_prev.size() and k < c_curr.size() and c_prev[k] == c_curr[k]) k++;
                    ll v = c_prev.size() + c_curr.size() - 2 * k;
                    vals[j] = min(vals[j], vals_prev[i] + v);
                }
            }
            configs_prev = configs;
            vals_prev = vals;

        }
        cout << "Case #" << caso++ << ": " << vals_prev[0] << '\n';
    }

}