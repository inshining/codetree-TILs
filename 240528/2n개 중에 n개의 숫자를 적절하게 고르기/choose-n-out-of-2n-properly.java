import java.util.*;

public class Main {
    public static int N, ans, sum;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[2 *N];
        ans = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < 2 * N; i++){
            int k = sc.nextInt();
            arr[i] = k;
            sum += k;
        }
        go(0,0, 0);
        System.out.println(ans);
    }
    public static void go(int idx, int total, int sel){
        if (sel == N){
            int v = Math.abs(2 * total - sum);
            ans = Math.min(ans, v);
            return;
        }
        if (idx >= 2 * N){
            return;
        }

        go(idx+1, total + arr[idx], sel +1);
        go(idx+1, total, sel);
    }
}