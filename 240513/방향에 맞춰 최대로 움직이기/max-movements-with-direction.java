import java.util.*;

public class Main {
    public static int N, ans;
    public static int[][] board, dir;
    public static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        dir = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                dir[i][j] = sc.nextInt();
            }
        }

        int sy,sx;
        sy = sc.nextInt();
        sx = sc.nextInt();

        sy--;
        sx--;

        ans = 0;
        go(sy,sx, 0);

        System.out.println(ans);
    }

    public static void go(int y, int x, int cnt){
        int d = dir[y][x];
        ans = Math.max(ans, cnt);

        for (int i = 1; i <= N; i++){
            int ny = y + dy[d] * i;
            int nx = x + dx[d] * i;
            
            if (ny >= 0 && ny < N && nx >= 0 && nx < N){
                if (board[y][x] < board[ny][nx]){
                    go(ny, nx, cnt+1);
                }
            }
        }
    }
}