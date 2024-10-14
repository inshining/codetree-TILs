import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] soccerSkills = new int[n];
        int[] baseballSkills = new int[n];
        
        for (int i = 0; i < n; i++) {
            soccerSkills[i] = scanner.nextInt();
            baseballSkills[i] = scanner.nextInt();
        }

        // dp 배열을 생성하고 초기화
        int[][][] dp = new int[n + 1][12][10];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 11; j++) {
                for (int k = 0; k <= 9; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // 시작 조건
        dp[0][0][0] = 0;

        // 동적 계획법으로 최대 합 계산
        for (int i = 1; i <= n; i++) {
            int soccer = soccerSkills[i - 1];
            int baseball = baseballSkills[i - 1];

            for (int j = 0; j <= 11; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (dp[i - 1][j][k] == -1) continue;

                    // 축구팀에 배정
                    if (j < 11) {
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i - 1][j][k] + soccer);
                    }

                    // 야구팀에 배정
                    if (k < 9) {
                        dp[i][j][k + 1] = Math.max(dp[i][j][k + 1], dp[i - 1][j][k] + baseball);
                    }
                }
            }
        }

        // 축구팀 11명, 야구팀 9명으로 최대 능력의 합을 얻습니다.
        System.out.println(dp[n][11][9]);
    }
}