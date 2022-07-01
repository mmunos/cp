#include <iostream>
#include <vector>
#include <queue>
#include <random>

using namespace std;

int main() {
    int N = 1000000;
    int pr[N+1];
    for(int i = 0; i <= N; i++){
        pr[i] = -1;
    }
    for(int i = 2; i <= N; i++){
        if(pr[i] < 0){
            pr[i] = i;
            for(int j = i*i; j <= N; j += i){
                pr[j] = i;
            }
        }
    }

}