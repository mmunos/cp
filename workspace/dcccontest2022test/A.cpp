#include <iostream>

using namespace std;

typedef long long int ll;

int main(){
    int x, y, n;
    cin >> x >> y >> n;
    for(int i = 1; i <= n; i++){
        if(i % x == 0 and i % y == 0){
            cout << "FizzBuzz\n";
        }
        else if(i % y == 0){
            cout << "Buzz\n";
        }
        else if(i % x == 0){
            cout << "Fizz\n";
        }
        else{
            cout << i << '\n';
        }
    }

}