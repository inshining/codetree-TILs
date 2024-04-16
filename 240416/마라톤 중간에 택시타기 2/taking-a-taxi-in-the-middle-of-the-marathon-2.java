import java.util.Scanner;
public class Main {
    public static int[][] board = new int[101][2];
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            board[i][0] = sc.nextInt();
            board[i][1] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < N-1; i++){
            int x = board[0][0];
            int y = board[0][1];
            int dist = 0;
            for (int j = 1; j < N; j++){
                if (j == i) continue;
                dist += Math.abs(x- board[j][0]) + Math.abs(y - board[j][1]);
                x = board[j][0];
                y = board[j][1];
            }
            ans = Math.min(ans, dist);
        }

        System.out.println(ans);
    }
}