import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> t = new TreeSet<>();

        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i< n; i++){
            int k =  sc.nextInt();
            t.add(k);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 1;
        for (int k : t){
            hm.put(k, idx);
            idx++;
        }

        for (int i = 0; i < q; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int a2 = Integer.MIN_VALUE;
            int b2 = Integer.MAX_VALUE;

            if (t.floor(a) != null){
                a2 = t.floor(a);
            }
            if (t.floor(b) != null){
                b2 = t.floor(b);
            }

            int f = 0;
            int c = n;
            if (a2 != Integer.MIN_VALUE){
                f = hm.get(a2);
            }

            if (b2 != Integer.MAX_VALUE){
                c = hm.get(b2);
            }

            int ans = c - f >= 0 ? c -f : 0;
            if (a == a2){
                ans++;
            }

            System.out.println(ans);
        }
    }
}