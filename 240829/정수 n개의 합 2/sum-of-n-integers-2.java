import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] prefix = new int[n+1];

        for (int i = 0; i < n; i++){
            prefix[i+1] = arr[i] + prefix[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1 - k; i++){
            ans = Math.max(ans, prefix[i+k] - prefix[i]);
        }

        System.out.println(ans);
    }
}