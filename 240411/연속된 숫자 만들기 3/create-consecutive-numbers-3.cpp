#include <iostream>
#include <cstdlib>

using namespace std;
int arr[3];
int main() {
    cin >> arr[0] >> arr[1] >> arr[2];
    int turn = 0;
    while (true){
        if (abs(arr[2] - arr[1]) == 1 && abs(arr[2]- arr[1]) == abs(arr[1]-arr[0])) break;
        
        if (abs(arr[2] - arr[1]) == 1 ){
            int temp = arr[1] -1;
            int t2 = arr[1];
            arr[2] = t2;
            arr[1] = temp;
        }
        else if (abs(arr[1]- arr[0]) == 1){
            int t2 = arr[1];
            arr[0] = t2;
            arr[1] = t2 + 1;
        } else if(abs(arr[1] - arr[0]) >= abs(arr[2]- arr[1])){
            int t1 = arr[0];
            int t2 = arr[1];
            arr[1] = t1 + 1;
            arr[2] = t2;
        } else{
            int t1 = arr[1];
            int t2 = arr[2];
            arr[0] = t1;
            arr[1] = t2 -1;
        }
        
        turn++;
}
    
    cout << turn;

    return 0;
}