import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            k = -k;
            pq.add(k);
        }

        for (int i = 0; i < m; i++){
            int k = pq.poll();
            k++;
            pq.add(k);
        }

        int k = pq.poll();
        k = -k;
        System.out.println(k);
    }
}