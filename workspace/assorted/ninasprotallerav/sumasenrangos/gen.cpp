#include <iostream>
#include <fstream>
#include <random>
#include <sstream>

using namespace std;
typedef long long ll;


mt19937 rn(std::chrono::system_clock::now().time_since_epoch().count());
std::uniform_int_distribution<unsigned long long> distr;
ofstream myfile;

void randomcase(int N, int Q, int counter){
    ll arr[N];
    for(int i = 0; i < N; i++){
        arr[i] = (distr(rn) % 1000000000) + 1;
    }
    int L[Q], R[Q];
    for(int i = 0; i < Q; i++){
        L[i] = (distr(rn) % N) + 1;
        R[i] = (distr(rn) % N) + 1;
        if(L[i] > R[i]) swap(L[i], R[i]);
    }

    stringstream ss;
    ss << std::setfill('0') << std::setw(2) << counter;
    myfile.open(ss.str() + ".in");
    myfile << N << endl;
    for(int i = 0; i < N; i++){
        myfile << arr[i];
        if(i < N-1) myfile << ' ';
        else myfile << endl;
    }
    myfile << Q << endl;
    for(int i = 0; i < Q; i++){
        myfile << L[i] << ' ' << R[i] << endl;
    }
    myfile.close();

    ll acc[N];
    ll tot = 0;
    for(int i = 0; i < N; i++){
         tot += arr[i];
         acc[i] = tot;
    }

    ll res[Q];

    for(int i = 0; i < Q; i++){
        int l = L[i], r = R[i];
        if(l == 1){
            res[i] = acc[r-1];
        }
        else{
            res[i] = acc[r-1] - acc[l-2];
        }
    }

    myfile.open(ss.str() + ".out");
    for(int i = 0; i < Q; i++){
        myfile << res[i] << endl;
    }
    myfile.close();
}
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int counter = 0;
    for(int iter = 0; iter < 5; iter++){
        randomcase(500, 100000, ++counter);
    }
    for(int iter = 0; iter < 5; iter++){
        randomcase(100000, 500, ++counter);
    }
    for(int iter = 0; iter < 10; iter++){
        randomcase(100000, 100000, ++counter);
    }
    return 0;
}
