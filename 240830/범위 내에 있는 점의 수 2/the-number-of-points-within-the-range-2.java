import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++){
            int pos = sc.nextInt();
            arr[pos] = 1;
        }

        for (int i = 1; i <= 1000000; i++){
            arr[i] = arr[i-1] + arr[i];    
        }

        for (int i = 0; i <q; i++){
            int a = sc.nextInt();
            int b= sc.nextInt();

            System.out.println(arr[b] - arr[a-1]);
        }

        // for (int i =0 ; i< 10; i++){
        //     System.out.println(arr[i]);
        // }
    }
}