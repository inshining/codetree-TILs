import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        int[][][] dp = new int[N][N][2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        dp[N-1][N-1][0] = board[N-1][N-1];
        dp[N-1][N-1][1] = board[N-1][N-1];
        for(int i = N-2; i >= 0; i--){
            dp[N-1][i][0] = Math.min(dp[N-1][i+1][0], board[N-1][i]);
            dp[N-1][i][1] = Math.max(dp[N-1][i+1][1], board[N-1][i]);
        }

        for(int i = N-2; i >= 0; i--){
            dp[i][N-1][0] = Math.min(dp[i+1][N-1][0], board[i][N-1]);
            dp[i][N-1][1] = Math.max(dp[i+1][N-1][1], board[i][N-1]);
        }

        for(int i = N-2; i >=0 ; i--){
            for(int j = N-2; j >= 0; j--){
                int x1 = Math.min(board[i][j], dp[i+1][j][0]);
                int y1 = Math.max(board[i][j], dp[i+1][j][1]);

                int x2 = Math.min(board[i][j], dp[i][j+1][0]);
                int y2 = Math.max(board[i][j], dp[i][j+1][1]);

                int a = Math.abs(x1 - y1);
                int b = Math.abs(x2 - y2);

                if( a <= b){
                    dp[i][j][0] = x1;
                    dp[i][j][1] = y1;
                }else{
                    dp[i][j][0] = x2;
                    dp[i][j][1] = y2;                    
                }
            }
        }

        int ans = Math.abs(dp[0][0][0] - dp[0][0][1]);
        System.out.println(ans);
    }
}