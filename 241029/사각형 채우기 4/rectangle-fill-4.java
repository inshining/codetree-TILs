import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int MOD = 10007;

        int[][][][] dp = new int[N+2][2][2][2];
        dp[1][0][0][1] = 1;
        dp[1][1][0][0] = 1;
        dp[1][1][1][1] = 1;

        for(int i = 1; i <= N; i++){
            dp[i+1][0][0][0] = (dp[i+1][0][0][0] + dp[i][0][0][0] + dp[i][1][0][0] + dp[i][0][0][1]) % MOD;
            dp[i+1][1][1][1] = (dp[i+1][1][1][1] + dp[i][0][0][0]) % MOD;
            dp[i+1][1][1][0] = (dp[i+1][1][1][0] + dp[i][0][0][1]) % MOD;
            dp[i+1][0][1][1] = (dp[i+1][0][1][1] + dp[i][1][0][0]) % MOD;
            dp[i+1][1][0][0] = (dp[i+1][1][0][0] + dp[i][0][1][1]) % MOD;
            dp[i+1][0][0][1] = (dp[i+1][0][0][1] + dp[i][1][1][0]) % MOD;

            dp[i+1][0][0][0] = (dp[i+1][0][0][0] + dp[i][1][1][1]) % MOD;


        }
        System.out.println(dp[N+1][0][0][0]);
    }
}