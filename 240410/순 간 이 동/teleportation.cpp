#include <iostream>
using namespace std;

int main() {
    int A, B, x, y;
    cin >> A >> B >> x >> y;
    int ans = -1;
    if (A > B){
        ans = A - B;
    } else{
        ans = B - A;
    }

    int p1 = A - x;
    if (p1 < 0){
        p1 = -p1;
    }
    if (B > y){
        p1 += (B - y);
    } else{
        p1 += (y - B);
    }

    int p2 = A - y;
    if (p2 < 0){
        p2 = -p2;
    }
    if (B > x){
        p2 += (B - x);
    } else{
        p2 += (x - B);
    }
    if (ans > p1){
        ans = p1;
    }
    if (ans > p2){
        ans = p2;
    }
    cout << ans;
    return 0;
}