import java.util.*;

public class Main {
    public static int N, a,b;
    public static char[] alphas = new char[101];
    public static int[] pos = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for (int i = 0; i < N; i++){
            alphas[i] = sc.next().charAt(0);
            pos[i] = sc.nextInt();
        }

        int ans = 0;
        for (int which = a; which <=b; which++){
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++){
                if (alphas[i] == 'S'){
                    d1 = Math.min(d1, Math.abs(which - pos[i]));
                } else{
                    d2 = Math.min(d2, Math.abs(which - pos[i]));
                }
            }

            if (d1 <= d2) ans++;
        }

        System.out.println(ans);
    }
}