import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][0]--;
            arr[i][1] = sc.nextInt();
            arr[i][1]--;
            arr[i][2] = sc.nextInt();
        }
        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < N; i++){
            for(int j = arr[i][0]; j <= arr[i][1]; j++){
                dp[i][j] = 0;
            }
        }

        for(int day = 1; day < M; day++){
            for(int cloth = 0; cloth < N; cloth++){
                if(dp[cloth][day] == -1) continue;
                for(int other = 0; other < N; other++){
                    if(dp[other][day-1] == -1) continue;
                    int v = Math.abs(arr[other][2] - arr[cloth][2]);
                    dp[cloth][day] = Math.max(dp[cloth][day], dp[other][day-1] + v);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, dp[i][M-1]);
        }
        System.out.println(ans);
    }
}