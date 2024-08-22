import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++){
            t.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++){
            int k = sc.nextInt();
            if (null == t.floor(k)){
                System.out.println(-1);
            } else{
                System.out.println(t.floor(k));
                t.remove(t.floor(k));
            }
        }

    }
}