import java.util.*;
public class Main {
    public static int N;
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[20];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++){
            dp[i] = dp[i-1] * 2 + (int) Math.pow(2, i-3);
        }
        System.out.println(dp[N]);
    }
}