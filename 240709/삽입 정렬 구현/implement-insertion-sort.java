import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N;i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < N; i++){
            int j = i -1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            
        }

        for (int i = 0; i < N;i++){
            System.out.print(arr[i] + " ");
        }
    }
}