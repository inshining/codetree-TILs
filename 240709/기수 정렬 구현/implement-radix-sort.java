import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_K = 6;
    public static final int MAX_DIGIT = 10; 

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for (int i = 0;i < n; i++){
            arr[i] = sc.nextInt();
        }
        go();

        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
       
    }
    public static void go(){
        int p = 1;
        for (int pos = 0; pos < MAX_K; pos++){
            ArrayList<Integer>[] arr_new = new ArrayList[MAX_DIGIT];
            for (int i = 0; i < 10; i++){
                arr_new[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < n; i++){
                int t = (arr[i]/ p) % 10;
                arr_new[t].add(arr[i]);
            }

            int index = 0;
            for (int i = 0; i < MAX_DIGIT; i++){
                for (int j =0; j < arr_new[i].size(); j++){
                    arr[index++] = arr_new[i].get(j);
                }
            }
            p *= 10;
        }
    }
}