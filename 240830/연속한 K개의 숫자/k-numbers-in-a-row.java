import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n ; i++){
            arr[i] = 1;
        }

        for (int i = 0; i < b; i++){
            int pos = sc.nextInt();
            arr[pos] = 0;
        }

        int[] prefix = new int[n+1];
        for (int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n+1 - k; i++){
            ans = Math.min(ans, k - (prefix[i + k] - prefix[i]));
        }
        System.out.println(ans);
    }
}