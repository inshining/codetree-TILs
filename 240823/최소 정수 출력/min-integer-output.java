import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (x == 0){
                if (pq.isEmpty()){
                    System.out.println(0);
                } else{
                    int k = pq.poll();
                    System.out.println(k);

                }
            } else{
                pq.add(x);
            }


        }
    }
}