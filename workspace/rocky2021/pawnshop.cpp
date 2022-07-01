#include <iostream>
#include <sstream>
#include <map>
#include <set>
using namespace std;


int main(){
    int n;
    cin >> n;
    int arr[n], brr[n];
    map<int, set<int> > poss;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        poss[arr[i]].insert(i);
    }
    stringstream ss;
    int b;
    int maxp = 0;
    for(int i = 0; i < n; i++){
        cin >> b;
        if(i == n-1){
            ss << b << '\n'; break;
        }
        ss << b << ' ';
        int p = *(poss[b].begin());
        poss[b].erase(p);
        maxp = max(maxp, p);
        if(maxp == i){
            ss << "# ";
        }
    }
    cout << ss.str();
}