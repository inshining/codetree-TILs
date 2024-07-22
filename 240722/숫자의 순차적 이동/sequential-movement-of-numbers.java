import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j =0 ; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        for (int t = 0; t < m; t++){
            for (int i = 1; i <= n * n; i++){
                move(i);
            }
        }

        for (int i =0 ; i < n; i++) System.out.println(Arrays.toString(board[i]).replace(",", "").replace("[", "").replace("]", ""));

    }

    public static void move(int v){

        for (int y = 0; y < n; y++){
                for (int x = 0; x < n; x++){
                    if (board[y][x] == v){
                        int max = 0;
                        int dir = -1;
                        for (int i = 0; i < 8; i++){
                            int ny = y + dy[i];
                            int nx = x + dx[i];

                            if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
                            if (max < board[ny][nx]){
                                max = board[ny][nx];
                                dir = i;
                            }
                        }

                        change(y,x, dir);
                        return;
                    }
                }
            }
    }

    public static void change(int y, int x, int dir){
        int temp = board[y][x];
        int ny = y + dy[dir]; int nx = x + dx[dir];

        board[y][x] = board[ny][nx];
        board[ny][nx] = temp;
    }
}