import java.util.*;

public class Main {
    public static int n,m;
    public static int[] arr;

    public static void main(String[] args) {    
        TreeSet<Integer> t = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for (int i = 1; i <= m; i++){
            t.add(i);
        }

        for (int i = 0; i < n; i++){

            int k = sc.nextInt();
            t.remove(k);

            System.out.println(t.last());
        }    


    }
}