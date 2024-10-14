import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N];
        int total = 0;
        for(int i = 0; i < N; i++){
            coins[i] = sc.nextInt();
            total += coins[i];
        }

        if(total % 2 == 1){
            System.out.println("No");
        }else{
            int target = total / 2;

            int[] dp = new int[target+1];
            int minV = Integer.MIN_VALUE;

            Arrays.fill(dp, minV);
            dp[0] = 0;
            for(int i = 0; i < N; i++){
                for(int j = target; j >= 0; j--){
                    if(j >= coins[i]){
                        if (dp[j - coins[i]] == minV) continue;
                        dp[j] = Math.max(dp[j], dp[j-coins[i]] + 1);
                    }
                }
                // System.out.println(Arrays.toString(dp));
            }
            String ans = dp[target] > 0 ? "Yes" : "No";
            System.out.println(ans);
        }
    }
}