#include <iostream>
#include <fstream>
#include <random>
#include <sstream>

using namespace std;
typedef long long ll;
ll solver(ll a, ll b){
    if(b <= 6*a && b >= a){
        return 1;
    }
    else{
        return 0;
    }
}
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    mt19937 rn(std::chrono::system_clock::now().time_since_epoch().count());
    std::uniform_int_distribution<unsigned long long> distr;
    ofstream myfile;
    int counter = 0;
    ll xs1[] = {2, 6, 19};
    for(int iter = 0; iter < 3; iter++){
        stringstream ss;
        ss << std::setfill('0') << std::setw(2) << ++counter;
        myfile.open(ss.str() + ".in");
        ll n = 3;
        ll x = xs1[iter];
        myfile << n << " " << x << endl;
        myfile.close();

        myfile.open(ss.str() + ".out");
        myfile << solver(n, x) << endl;
        myfile.close();
    }
    ll xs2[] = {5, 9, 30, 54, 55, 800};
    for(int iter = 0; iter < 6; iter++){
        stringstream ss;
        ss << std::setfill('0') << std::setw(2) << ++counter;
        myfile.open(ss.str() + ".in");
        ll n = 9;
        ll x = xs2[iter];
        myfile << n << " " << x << endl;
        myfile.close();

        myfile.open(ss.str() + ".out");
        myfile << solver(n, x) << endl;
        myfile.close();
    }
    for(int iter = 0; iter < 21; iter++){
        stringstream ss;
        ss << std::setfill('0') << std::setw(2) << ++counter;
        myfile.open(ss.str() + ".in");
        ll n = (distr(rn) % 100) + 1;
        ll x = (distr(rn) % 1000) + 1;
        myfile << n << " " << x << endl;
        myfile.close();

        myfile.open(ss.str() + ".out");
        myfile << solver(n, x) << endl;
        myfile.close();
    }
    return 0;
}
