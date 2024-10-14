import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[N+1][N+1];
        dp[1][1] = board[0][0];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == 1 && j== 1) continue;
                int other = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(other, board[i-1][j-1]);
            }
        }

        System.out.println(dp[N][N]);
    }
}