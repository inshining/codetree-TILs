import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        for (int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                result = Math.max(result, bomb(i,j));
            }
        }
        System.out.println(result);

    }

    public static int bomb(int y, int x){
        int[][] temp = new int[n][n];
        for (int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                temp[i][j] = board[i][j];
            }
        }

        int v = temp[y][x];
        temp[y][x] = 0;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int d = 0; d <4; d++){
            int ny = y;
            int nx = x;
            for (int t = 1; t < v; t++){
                ny = ny + dy[d];
                nx = nx + dx[d];
                if (out(ny,nx)){
                    break;
                }
                temp[ny][nx] = 0;
            }
        }

        for (int c = 0; c < n; c++){
            int[] line = new int[n];
            int idx = 0;
            for (int r = n-1; r >= 0; r--){
                if (temp[r][c] > 0){
                    line[idx++] = temp[r][c];
                }
            }

            for (int r = n-1; r >= 0; r--){
                temp[r][c] = line[(n-1)- r];
            }
        }

        int ans = 0;
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (temp[r][c] == 0) continue;
                for (int d = 1; d <3; d++){
                    int nr = r + dy[d];
                    int nc = c + dx[d];
                    if (out(nr,nc)) continue;
                    if (temp[r][c] == temp[nr][nc]){
                        ans++;
                    }
                }
            }
        }

        // for (int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(temp[i]));

        // }
        return ans;
    }

    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || n <= x);
    }
}