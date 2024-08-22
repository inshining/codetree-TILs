import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            String s = sc.next();

            if (s.equals("push")){
                int a = sc.nextInt();
                pq.add(a);
            } else if(s.equals("pop")){
                if (!pq.isEmpty()){
                    int k = pq.poll();
                    System.out.println(k);
                }
            } else if(s.equals("size")){
                System.out.println(pq.size());

            } else if(s.equals("empty")){
                int e = pq.isEmpty() ? 1 : 0;
                System.out.println(e);

            } else if(s.equals("top")){
                System.out.println(pq.peek());

            } 
        }
    }
}