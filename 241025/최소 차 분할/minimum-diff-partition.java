import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int[][][] dp = new int[N][N+1][N+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= N; j++){
                for(int k = 0; k <= N; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][1][0] = arr[0];
        dp[0][0][1] = arr[0];

        for(int i = 1; i < N; i++){
            int total = i + 1;
            for(int j = 0; j <= total; j++){
                int k = total - j;
                if(j > 0){
                    int a = Math.abs(dp[i][j][k]);
                    int b= Math.abs(dp[i-1][j-1][k] + arr[i]);
                    if(a > b){
                        dp[i][j][k] = dp[i-1][j-1][k] + arr[i];
                    }
                }

                if(k > 0){
                    int a = Math.abs(dp[i][j][k]);
                    int b= Math.abs(dp[i-1][j][k-1] - arr[i]);
                    if(a > b){
                        dp[i][j][k] = dp[i-1][j][k-1] - arr[i];
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(ans > Math.abs(dp[N-1][i][j])){
                    ans = Math.abs(dp[N-1][i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}