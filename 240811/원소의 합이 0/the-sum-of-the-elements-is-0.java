import java.util.*;

public class Main {

    public static HashMap<Integer, Integer> m1 = new HashMap<>();
    public static HashMap<Integer, Integer> m2 = new HashMap<>();
    public static HashMap<Integer, Integer> m3 = new HashMap<>();

    public static int[] a,b,c,d;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++){
            c[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            d[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int v = m1.getOrDefault(a[i] + b[j], 0);
                m1.put(a[i] + b[j], v + 1);
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int diff = - c[i] - d[j];
                if (m1.getOrDefault(diff, 0) > 0)
                    ans += m1.get(diff);
            }
        }

        System.out.println(ans);
        


    }
}