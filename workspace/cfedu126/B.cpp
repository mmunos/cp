#include <iostream>
// #include <algorithm>
#include <queue>
// #include <map>
// #include <unordered_map>
// #include <set>
// #include <unordered_set>
// #include <sstream>

using namespace std;

typedef long long int ll;
ll mod = 998244353;
    
#define N 32768
int dist[N];

int bfs(int x){
}

int main(){
    for(int i = 0; i < N; i++){
        dist[i] = -1;
    }
    dist[0] = 0;
    queue<int> q;
    q.push(0);
    while(!q.empty()){
        int u = q.front(); q.pop();
        int v1 = u == 0 ? N - 1 : u - 1;
        if(dist[v1] < 0){
            dist[v1] = dist[u] + 1;
            q.push(v1);
        }
        if(u % 2 == 0){
            int v2 = u / 2;
            if(dist[v2] < 0){
                dist[v2] = dist[u] + 1;
                q.push(v2);
            }
            int v3 = u / 2 + N / 2;
            if(dist[v3] < 0){
                dist[v3] = dist[u] + 1;
                q.push(v3);
            }
        }

    }
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        cout << dist[a];
        if(i == n-1) cout << '\n';
        else cout << ' ';
    }
}