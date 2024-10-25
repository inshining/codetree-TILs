import java.util.*;
public class Main {
    static int MAX_M = 10001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] exe = new int[N+1];
        int[] times = new int[N+1];
        for(int i = 1; i <= N; i++){
            exe[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][MAX_M];
        for(int i = 1; i <= N; i++){
            int e = exe[i];
            int t = times[i];
            for(int j = 0; j < MAX_M; j++){
                if(t <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-t] + e);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }
        int ans = -1;
        for(int i = 0; i < MAX_M; i++){
            if(dp[N][i] >= M){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}