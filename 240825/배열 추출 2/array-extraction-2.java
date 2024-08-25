import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq1 = new PriorityQueue<>();
        PriorityQueue<Long> pq2 = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            long k = (long) sc.nextInt();
            
            if ( k  == 0){
                long ans = 0;

                if (pq1.size() > 0 && pq2.size() > 0){
                    long a = pq1.peek();
                    long b = pq2.peek();
                    b = -b;

                    if (a == b || a > b){
                        ans = pq2.poll();
                    } else {
                        ans = pq1.poll();
                    }
                } else if(pq1.size() > 0){
                    ans = pq1.poll();
                } else if(pq2.size() > 0){
                    ans = pq2.poll();
                }
                System.out.println(ans);
            } else if (k < 0){
                pq2.add(k);
            } else{
                pq1.add(k);
            }
        }

    }
}