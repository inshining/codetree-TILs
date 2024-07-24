import java.util.*;

public class Main {
    public static int n, num, maxV, block;
    public static int[][] board;
    public static boolean[][] visit;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx= {0,1 ,0, -1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j =0 ; j < n; j++){
                if (visit[i][j]) continue;
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                num =0;
                go(i, j);
                if (num >= 4){
                    block++;
                }
                maxV = Math.max(maxV, num);
            }
        }

        System.out.println(block + " " + maxV);
    }

    public static void go(int y, int x){
        visit[y][x] = true;
        num++;
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
            if (visit[ny][nx]) continue;
            if (board[y][x] == board[ny][nx]) go(ny, nx);
        }
    }
}