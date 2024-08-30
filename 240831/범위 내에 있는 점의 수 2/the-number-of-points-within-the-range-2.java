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
        int[] prefix = new int[1000001];
        prefix[0] = arr[0];

        for (int i = 1; i <= 1000000; i++){
            prefix[i] = prefix[i-1] + arr[i];    
        }

        for (int i = 0; i <q; i++){
            int a = sc.nextInt();
            int b= sc.nextInt();

            int result = prefix[b] - prefix[a];
            if (arr[a] == 1){
                result++;
            }
            System.out.println(result);
        }
        // System.out.println();
        // for (int i = 0; i <= 9; i++){
        //     System.out.println(prefix[i]);
        // }
    }
}