import java.util.*;
public class Main {
    static final int MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100;

    static int[][] num = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static int ans = MAX;
    static int N;

    static void init(){
        for(int i = 0; i < N; i++){
            for(int j = 0;j < N; j++ ){
                dp[i][j] = MAX;

            }
        }
    
    dp[0][0] = num[0][0];
    for(int i = 1; i < N; i++){
        dp[i][0] = Math.max(dp[i-1][0], num[i][0]);
    }
    for(int j = 1; j < N; j++){
        dp[0][j] = Math.max(dp[0][j-1], num[0][j]);
    }
}
    static int solve(int low){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(num[i][j] < low) num[i][j] = MAX;
            }
        }

        init();

        for(int i = 1; i < N; i++)
            for(int j = 1; j < N; j++)
                dp[i][j] = Math.max(
                    Math.min(dp[i-1][j], dp[i][j-1]),
                    num[i][j]
                );
        return dp[N-1][N-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                num[i][j] = sc.nextInt();
            }
        }

        for(int lowerBound = 1; lowerBound <= MAX_N; lowerBound++){
            int upperBound = solve(lowerBound);
            if(upperBound == MAX) continue;
            ans = Math.min(ans, upperBound - lowerBound);
        }
       System.out.println(ans);
    }
}