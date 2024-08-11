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

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int v = m2.getOrDefault(c[i] + d[j], 0);
                m2.put(c[i] + d[j], v + 1);
            }
        }

        for (int k1 : m1.keySet()){
            for (int k2 : m2.keySet()){
                int v1 = m1.get(k1);
                int v2 = m2.get(k2);

                int sum = k1 + k2;
                int v = m3.getOrDefault(sum, 0);
                m3.put(sum, v + (v1 * v2));
            }
        }

        System.out.println(m3.getOrDefault(0, 0));
        


    }
}