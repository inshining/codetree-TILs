import java.util.*;

public class Main {
    public static int MAX_N = 1005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a= new int[MAX_N];
        int[] b= new int[MAX_N];

        for(int i = 1; i <= N; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            b[i] = sc.nextInt();
        }   

        int[][] dp = new int[MAX_N][MAX_N];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++) dp[i][j] = -1;
        }
        dp[0][0] = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dp[i][j] == -1) continue;

                if(a[i+1] < b[j+1]) dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                if(a[i+1] > b[j+1]) dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + b[j+1]);

                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
        }

        // for(int i = 0; i <= N; i++){
        //     for(int j = 0; j <= N; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        for(int i = 0; i <= N; i++){
            ans = Math.max(ans, dp[i][N]);
            ans = Math.max(ans, dp[N][i]);
        }

        System.out.println(ans);
    }
}