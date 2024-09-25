import java.util.*;

public class Main {
    public static long ans, total;
    public static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] l = new long[n];

        for (int i =0; i < n; i++){
            l[i] = sc.nextLong();
        }

        ans = Long.MIN_VALUE;

        arr = new long[n+1];
        arr[0] = 0L;

        for (int i = 1; i <= n; i++){
            arr[i] = l[i-1] + arr[i-1];
        }
        total = arr[n];
        int start = 0;
        int end = 0;

        while (end <= n && start <= end){
            long v = arr[end] - arr[start];
            long other = total - v;
            if (v < other){
                ans = Math.max(ans, v);
                end++;
            } else{
                ans = Math.max(ans, other);
                start++;
            }
        }
        // for (int i = 0; i < n; i++){
        //     for (int j = i+1; j < n; j++){
        //         long v = arr[j] - arr[i]; 
        //         long counter = total - v;
        //         long min = Math.min(v, counter);
        //         ans = Math.max(ans, min);
        //     }
        // }
        System.out.println(ans);
        // sc.close();
    }
}