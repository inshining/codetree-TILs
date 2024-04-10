#include <iostream>
#include <string>
using namespace std;

int n, start, idx, dis;
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
                idx = i;
            }
            if (i != (seats.size() -1)) start=i;
        }
    }
    seats[(idx - dis + idx)/2] = '1';

    start = 0;
    dis = 1003;

    for (int i=1; i < seats.size(); i++){
        if (seats[i] == '1'){
            if (i - start < dis){
                dis = i - start;
            }
            if (i != (seats.size()-1)) start=i;
        }
    }
    cout << dis;
    return 0;
}