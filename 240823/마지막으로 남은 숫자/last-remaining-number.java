import java.util.*;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            k = -k;
            pq.offer(k);
        }

        while (pq.size() >= 2){
            int x = pq.poll();
            int y = pq.poll();

            if (x != y){
                int k = x - y;
                k = -k;
                pq.offer(k);
            }
        }

        int k = pq.poll();
        System.out.println(k);
    }
}