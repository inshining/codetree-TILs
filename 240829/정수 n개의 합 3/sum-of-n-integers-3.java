import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] q = new int[n+1][n+1];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                q[i+1][j+1] = sc.nextInt() + q[i+1][j] + q[i][j+1] - q[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n +1  - k; i++){
            for (int j = 0; j < n +1  - k; j++){
                ans = Math.max(ans, q[i+k][j+k] - q[i+k][j] - q[i][j+k] + q[i][j]);
            }
        }
        System.out.println(ans);
    }
}