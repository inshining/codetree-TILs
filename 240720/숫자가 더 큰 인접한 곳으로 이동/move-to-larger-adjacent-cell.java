import java.util.*;

public class Main {
    public static int n, r, c;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[n][n];
        r -= 1;
        c -= 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        go(r,c);
        
    }

    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || n <= x);
    }

    public static void go(int y, int x){
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        System.out.print(board[y][x] + " ");
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (out(ny, nx)){
                continue;
            }
            if (board[ny][nx] > board[y][x]){
                go(ny,nx);
                return;
            }
        }
    }
}