import java.util.*;

public class Main {
    public static int n, r, c;
    public static int[][] board; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        r = sc.nextInt();
        c = sc.nextInt();

        r -= 1;
        c -= 1;
        
        bomb();
        gravity();
        for (int i = 0; i < n; i++){
            print(board[i]);
        }

    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr).replace(",", "").replace("[","").replace("]", ""));
    }

    public static void bomb(){
        int v = board[r][c];
        board[r][c] = 0;
        int[] dy  = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++){
            int ny = r + dy[d];
            int nx = c + dx[d];
            for (int i = 1; i < v; i++){
                if (out(ny,nx)){
                    break;
                }
                board[ny][nx] = 0;

                ny += dy[d];
                nx += dx[d];
            }
        }
    }

    public static void gravity(){
        for (int i = 0; i < n; i++){
            int[] temp = new int[n];
            int idx = 0;

            for (int j = n-1; j >= 0; j--){
                if (board[j][i] > 0){
                    temp[idx] = board[j][i];
                    idx++;
                }
            }

            for (int j = 0; j < n; j++){
                board[n-1-j][i] = temp[j];
            }
            
        }
    }

    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || n <= x);
    }
}