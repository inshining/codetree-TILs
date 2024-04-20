import java.util.*;

public class Main {
    public static int N;
    public static int[] a = new int[10];
    public static int[] b = new int[10];
    public static int[] c = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < 10; i++){
            for (int j=1; j <10; j++){
                for (int k=1; k <10; k++){
                    if (i == j || j == k || i ==k) continue;

                    boolean succeeded = true;
                    for (int idx=0; idx < N; idx++){
                        int x = a[idx] / 100;
                        int y = a[idx] / 10 % 10;
                        int z = a[idx] % 10;

                        int n1 = 0;
                        int n2 = 0;

                        if (i == x) n1++;
                        if (j == y) n1++;
                        if (k == z) n1++;
                        if (x == j || x == k) n2++;
                        if (y == i || y == k) n2++;
                        if (z == i || z == j) n2++;

                        if (n1 != b[idx] || n2 != c[idx]){
                            succeeded = false;
                            break;
                        }
                    }
                    if (succeeded) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}