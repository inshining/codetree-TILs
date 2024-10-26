import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];

        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i<= N; i++){
            Arrays.fill(dp[i], -1001);
        }
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }
        dp[0][0] = 0;
        dp[1][1] = arr[1];
        for(int i = 2; i <= N; i++){
            int v = arr[i];
            for(int j= 1; j <= M; j++){

                // if(i == 6 && j == 3)
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + v);

                dp[i][j] = Math.max(dp[i][j], dp[i-2][j-1] + v);
            }
        }
        // for(int i = 1; i <= N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(dp[N][M]);
    }
}