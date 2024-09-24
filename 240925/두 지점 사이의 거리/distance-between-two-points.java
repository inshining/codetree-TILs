import java.util.*;

public class Main {
    public static long ans, total, n;
    public static ArrayList<Long> arr;
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
        // scanner.close();
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> l = new ArrayList<>();

        n = sc.nextLong();
        for (int i =0; i < n; i++){
            l.add(sc.nextLong());
        }

        ans = Long.MIN_VALUE;

        // Collections.sort(l);

        arr = new ArrayList<>();
        arr.add(0L);

        for (int i = 0; i < n; i++){
            long v = arr.get(arr.size() - 1) + l.get(i);
            arr.add(v);
        }
        total = arr.get(arr.size() - 1);
        // System.out.println(arr);
        // go(1);
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                long v = arr.get(j) - arr.get(i); 
                long min = Math.min(v, total - v);
                ans = Math.max(ans, min);
            }
        }
        System.out.println(ans);
    }
}