import java.util.*;

public class Main {
    public static int N, a, b,c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int ans = 0;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                for (int k = 1; k <= N; k++){
                    if (Math.abs(a - i) <= 2) ans++;
                    else if(Math.abs(b - j) <= 2) ans++;
                    else if(Math.abs(c - k) <= 2) ans++;

                }
            }
        }
        System.out.println(ans);
    }
}