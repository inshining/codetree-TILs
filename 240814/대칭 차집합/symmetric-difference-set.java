import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int an = sc.nextInt();
        int bn = sc.nextInt();

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        for (int i = 0; i < an; i++){
            A.add(sc.nextInt());
        }

        for (int i = 0; i < bn; i++){
            int k = sc.nextInt();
            if (A.contains(k)) {
                A.remove(k);
                continue;
            }
            B.add(k);
        }

        int ans = A.size() + B.size();
        // System.out.println(A);
        // System.out.println(B);

        System.out.println(ans);
    }
}