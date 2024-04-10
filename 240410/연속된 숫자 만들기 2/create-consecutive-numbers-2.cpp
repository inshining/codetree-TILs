#include <iostream>
#include <cstdlib>
using namespace std;

int a, b, c, ans;
int main() {
    cin >> a >> b >> c;
    if (abs(c - b) == 1 && abs(b-a) == 1){
        ans = 0;
    } else if(abs(c - b) ==2 || abs(b-a) ==2){
        ans = 1;
    } else{
        ans = 2;
    }
    cout << ans;
    return 0;
}