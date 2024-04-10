#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    for (int i=0; i <2; i++){
        for (int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                cout << "*";
            }
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}