import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        t.add(0);
        int n = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            t.add(k);
            if (t.lower(k) != null){
                int l = t.lower(k);
                ans = Math.min(ans, Math.abs(l - k));
            }
            
            if (t.higher(k) != null){
                int r = t.higher(k);
                ans = Math.min(ans, Math.abs(r - k));
            } 

            System.out.println(ans);
        }
    }
}