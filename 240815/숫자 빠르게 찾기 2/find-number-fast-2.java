import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i <n; i++){
            t.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++){
            int v = sc.nextInt();
            if (t.last() < v){
                System.out.println(-1);
            } else{
            int r = t.ceiling(v);
            System.out.println(r);
            }

        }
    }
}