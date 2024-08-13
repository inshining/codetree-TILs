import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();

        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++){
            h1.add(sc.nextInt());
        }
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++){
            int k = sc.nextInt();
            int v = h1.contains(k) ? 1 :  0;
            System.out.print( v + " ");
        }

    }
}