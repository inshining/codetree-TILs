import java.util.*;
public class Main {
    public static int n, m, t;
    public static int[][] board;
    public static int[][] balls;
    public static int[][] nextBalls;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        board = new int[n][n];
        balls = new int[n][n];

        for (int i =0 ; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for (int i =0 ; i < m; i++){
            int y = sc.nextInt();
            int x= sc.nextInt();

            balls[y-1][x-1] = 1;
        }

        for (int i = 0; i < t; i++){
            nextBalls = new int[n][n];
            for (int y = 0; y < n; y++){
                for (int x = 0; x < n; x++){
                    if (balls[y][x] == 1){
                        move(y,x);
                    }
                }
            }

            for (int y = 0; y < n; y++){
                for (int x = 0; x < n; x++){
                    if (nextBalls[y][x] > 1){
                        nextBalls[y][x] = 0;
                    }
                    balls[y][x] = nextBalls[y][x];
                }
            }


        }
        int ans = Arrays.stream(balls).flatMapToInt(Arrays::stream).sum();
        // for (int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(balls[i]));
        // }
        System.out.println(ans);
    }

    public static void move(int y, int x){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int v = 0;
        int dir = 0;
        for (int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
            if (v < board[ny][nx]){
                v = board[ny][nx];
                dir = d;
            }
        }
        nextBalls[y + dy[dir]][x + dx[dir]] += 1;
    }
}