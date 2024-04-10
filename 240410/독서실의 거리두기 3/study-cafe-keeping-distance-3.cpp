#include <iostream>
#include <string>
using namespace std;

int n, start, end, dis;
string seats;
int main() {
    cin >> n;
    cin >> seats;
    start = 0;
    dis = 0;
    for (int i =1; i < seats.size(); i++){
        if (seats[i] == '1'){
            if (i - start > dis){
                dis = i - start; 
            }
            if (i != (seats.size() -1)) start=i;
        }
    }

    cout << (int)dis/2;
    return 0;
}