import java.util.*;
public class Main {
    static int MAX_N = 101;
    static int MAX_M = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[MAX_N];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = 1; i <= N; i++){
            total += arr[i];
        }

        boolean[][] dp = new boolean[MAX_N][MAX_M];
        dp[0][0] = true;
        for(int i = 1; i<= N; i++){
            int v = arr[i];
            for(int j = 0; j < MAX_M; j++){
                if(v <= j && dp[i-1][j-v]) dp[i][j] = true;
                if(dp[i-1][j]) dp[i][j] = true;
            }
        }

        int ans = total;
        for(int j = 0; j <= total; j++){
            if(dp[N][j]) ans = Math.min(ans, Math.abs(j - (total - j)));
        }
        System.out.println(ans);
    }
}