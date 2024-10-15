import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX_N = 100;
        int N = sc.nextInt();
        int[][] dp = new int[2 * MAX_N + 1][2* MAX_N+1];
        int[] red = new int[2*MAX_N+1];
        int[] blue = new int[2* MAX_N+1];
        for(int i = 0; i <= 2 *MAX_N; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        for(int i = 1; i <= 2* N; i++){
            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        for(int i = 1; i <= 2*N; i++){
            for(int j = 0; j <= i; j++){
                if(j> 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + red[i]);
                
                if(i - j > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + blue[i]); 
                
            }
        }
        System.out.println(dp[2*N][N]);
    }
}