import java.util.*;
public class Main {
    public static int N;
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[20];
        for (int i = 0; i < 20; i++){
            dp[i] = -1;
        }
        dp[0] = 1;
        go(N);
        System.out.println(dp[N]);
        
    }
    public static int go(int k){
        if (dp[k] != -1){
            return dp[k];
        }

        int num = 0;
        for (int i = 0; i < k; i++){
            num += go(i) * go(k - i - 1);
        }
        return dp[k] = num;
    }
}