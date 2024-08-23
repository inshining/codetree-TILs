import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        pq.offer(arr[n-1]);
        pq.offer(arr[n-2]);

        double ans = 0;
        int total = arr[n-1] + arr[n-2];
        for (int i = n-3; i >= 0; i--){
            int k = pq.poll();
            total -= k;
            ans = Math.max(ans, (total / pq.size()));
            total += k;
            pq.offer(k);
            pq.offer(arr[i]);
            total += arr[i];
        }
        System.out.println(String.format("%.2f", ans));
    }
}