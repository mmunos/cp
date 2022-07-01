#include <iostream>
#include <cmath>
#include <algorithm> 
using namespace std;

const int N = 300003;
long long facc[N+1];
int fiacc[N+1], f[N+1];
int sqN = 560;

int main(){
    int n;
    cin >> n;
    int sqn = 440;
    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    long long res[n];
    for(int i = 0; i < n; i++) res[i] = 0;
    for(int i = 0; i <= N; i++) facc[i] = 0;
    for(int i = 0; i <= N; i++) fiacc[i] = 0;
    long long asum = 0;
    long long smallmods[sqN];
    for(int i = 1; i < sqN; i++) smallmods[i] = 0;
    int nextblock = sqn;
    for(int iter = 0; iter < n; iter++){
        if(iter > 0 && iter % sqn == 0){//update
            for(int d = 1; d <= sqn && iter-d >= 0; d++){
                for(int i = 1; i < sqN; i++){
                    smallmods[i] += (arr[iter-d] / i) * i;
                }
                f[arr[iter-d]]++;
            }
            for(int i = 1; i <= N; i++){
                facc[i] = f[i] * i;
                fiacc[i] = f[i];
                facc[i] += facc[i-1];
            }
            for(int i = N-1; i >= 1; i--){
                fiacc[i] += fiacc[i+1];
            }
            nextblock += sqn;
        }
        long long a = arr[iter];
        __int128 val = 0;

        //a mod the rest
        //n * a - sum_{k = 1..N} k * c(k) * [a / k] . 
        val += a * iter;
        if(a < 2*sqN){
            for(int i = 1; i < a; i++){
                val -= (a / i) * i * f[i];
            }
        }
        else{
            int sqa = (int)sqrt(arr[iter]);
            for(int d = 1; d < sqa; d++){
                int l = a / (d+1) + 1, r = a / d;
                val -= (facc[r] - facc[l-1]) * d;
            }
            for(int i = a / sqa; i >= 1; i--){
                val -= (a / i) * i * f[i];
            }
        }

        //the rest mod a
        //sum_{i < n} arr[i] - sum_{k = 1..N} c(k) * a * [k / a] . 
        val += asum;
        if(a < sqN){
            val -= smallmods[a];
        }
        else{
            long long blaacc = 0;
            for(int i = a; i <= N; i += a){
                blaacc += fiacc[i];
            }
            val -= blaacc * a;
        }

        res[iter] += val;
        //offline update
        for(int it = iter+1; it < nextblock && it < n; it++){
            res[it] -= a * (arr[it] / a);
            res[it] -= arr[it] * (a / arr[it]);
        }

        asum += a;
    }
    long long totres = 0;
    for(int i = 0; i < n; i++){
        totres += res[i];
        cout << totres;
        if(i < n-1) cout << ' ';
    }
    cout << '\n';
}