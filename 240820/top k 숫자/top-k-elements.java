import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        TreeSet<Integer> t = new TreeSet<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            t.add(a);
        }

        int v = t.last();
        for (int i = 0; i < k; i++){
            System.out.print(v + " ");
            v = t.lower(v);
        }
    }
}