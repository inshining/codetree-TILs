import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();
        int ans = 1;
        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            if (min.size() < 3){
                min.add(k);
                ans *= k;
                if (min.size() < 3){
                    System.out.println(-1);
                } else{
                    System.out.println(ans);
  
                }
            } else{
                if (min.peek() > k){
                    int a = min.poll();
                    ans /= a;
                    ans *= k;
                    min.add(k);
                }
                System.out.println(ans);
            }
        }
    }
}