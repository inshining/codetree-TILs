import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] soccer = new int[n];
        int[] baseball = new int[n];

        for (int i = 0; i < n; i++) {
            soccer[i] = scanner.nextInt();
            baseball[i] = scanner.nextInt();
        }

        // DP 배열 선언 및 초기화
        int[][][] dp = new int[n + 1][12][10];

        // DP 배열 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 11; j++) {
                for (int k = 0; k <= 9; k++) {
                    // i번째 학생을 아무 팀에도 넣지 않는 경우
                    dp[i][j][k] = dp[i - 1][j][k];
                    
                    // i번째 학생을 축구팀에 넣는 경우
                    if (j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k] + soccer[i - 1]);
                    }

                    // i번째 학생을 야구팀에 넣는 경우
                    if (k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1] + baseball[i - 1]);
                    }
                }
            }
        }

        // 최대 능력 합 출력
        System.out.println(dp[n][11][9]);
    }
}