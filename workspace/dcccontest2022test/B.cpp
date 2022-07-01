#include <iostream>
//Hello, I'm Mr. Frog

using namespace std;

typedef long long int ll;

void dothething(int x){
    if(x == 1){
        cout << x;
    }
    else{
        dothething(x-1);
        cout << " " << x << " ";
        dothething(x-1);
    }
}

int main(){
    int n;
    cin >> n;
    dothething(n);
    cout << '\n';
}