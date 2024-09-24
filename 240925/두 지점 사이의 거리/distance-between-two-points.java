import java.util.*;

public class Main {
    public static long ans, total;
    public static long[] arr;
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // long[] distances = new long[n];
        // long totalDistance = 0;

        // for (int i = 0; i < n; i++) {
        //     distances[i] = scanner.nextLong();
        //     totalDistance += distances[i];
        // }

        // long[] prefixSum = new long[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     prefixSum[i] = prefixSum[i - 1] + distances[i - 1];
        // }

        // long maxDistance = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         long clockwise = prefixSum[j] - prefixSum[i];
        //         long counterClockwise = totalDistance - clockwise;
        //         long distance = Math.min(clockwise, counterClockwise);
        //         maxDistance = Math.max(maxDistance, distance);
        //     }
        // }

        // System.out.println(maxDistance);
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
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                long v = arr[j] - arr[i]; 
                long counter = total - v;
                long min = Math.min(v, counter);
                ans = Math.max(ans, min);
            }
        }
        System.out.println(ans);
        // sc.close();
    }
}