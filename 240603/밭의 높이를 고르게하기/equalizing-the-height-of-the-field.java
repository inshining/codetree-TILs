import java.util.*;
public class Main {
    public static int N, H, T;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        T = sc.nextInt();

        arr = new int[N+1];

        for (int i = 1; i <= N; i++){
            arr[i] = arr[i-1] + Math.abs(sc.nextInt() - H);
        }
        int ans = Integer.MAX_VALUE;
        for (int i =0 ; i < N - T; i++){
            ans = Math.min(ans, arr[i+T] - arr[i]);
        }
        System.out.println(ans);
    }
}