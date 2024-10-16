import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        long[][] dp = new long[N+1][41];
        // for(int i = 0; i <= N; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        dp[0][20] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = -20; j <= 20; j++){
                if(dp[i-1][j+20] == -1) continue;
                if(j+ arr[i] > 20) continue;
                dp[i][j+20 + arr[i]] += dp[i-1][j+20];
            }

            for(int j = -20; j <= 20; j++){
                if(dp[i-1][j+20] == -1) continue;
                if(j - arr[i] < -20) continue;
                dp[i][j+20 - arr[i]] += dp[i-1][j+20];
            }
        }

        // for(int i = 0; i <= N; i++){
        //     for(int j = 10; j <= 30; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[N][M+20]);
    }
}