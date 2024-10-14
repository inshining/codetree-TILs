import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][4];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= N; i++){
            if(i >= 2 && dp[i-2][0] != Integer.MIN_VALUE) dp[i][0] = dp[i-2][0] + arr[i];
            for(int j = 1; j <= 3; j++){
                if(i >= 2)
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j] + arr[i]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + arr[i]);
            }
        }

        // for(int i = 0; i <= N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        int ans = 0;
        for(int i = 0; i <= 3; i++){
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}