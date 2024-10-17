import java.util.*;

public class Main {
    public static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> right = new PriorityQueue<>();
    public static int mid;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int mid = -1;
            left.clear();
            right.clear();
            for (int j = 1; j <= n; j++){
                int k = sc.nextInt();
                if(mid == -1){
                    mid = k;
                } else{
                    if(mid < k){
                        right.add(k);
                    } else{
                        left.add(k);
                    }
                }
                
                if (j % 2 == 1){
                    if(right.size() != left.size()) {
                        if(right.size() < left.size()){
                            right.add(mid);
                            mid = left.poll();
                        }else{
                            left.add(mid);
                            mid = right.poll();
                        }
                    }
                    System.out.print(mid + " ");
                }
            }
            System.out.println();
        }
    }

    public static void print(int mid){
        System.out.println(mid);
    }
}