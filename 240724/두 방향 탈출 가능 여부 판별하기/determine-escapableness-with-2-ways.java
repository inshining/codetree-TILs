import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[][] board;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];

        for (int i =0 ; i <n;i++){
            for (int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }
        go(0, 0);
        System.out.println(ans);

    }

    public static void go(int y, int x ){
        if (y == n -1 && x == m-1){
            ans = 1;
            return;
        }

        if (ans == 1){
            return;
        }

        if (x+1 < m && board[y][x+1] == 1){
            go(y, x+1);
        }

        if (y+1 < n && board[y+1][x] == 1){
            go(y+1, x);
        }
    }
}