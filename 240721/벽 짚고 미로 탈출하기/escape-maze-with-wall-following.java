import java.util.*;

public class Main {
    public static int n, r, c, ans, cnt;
    public static char[][] board;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int dir = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        r -= 1;
        c -= 1;

        board = new char[n][n];

        for (int i =0; i < n; i++){
            String s = sc.next();
            for (int j = 0; j < n; j++){
                board[i][j] = s.charAt(j);
            }
        }

        // for (int i =0 ; i < n ; i++){
        //     for (int j =0 ; j < n; j++){
        //         if (board[i][j] == '#'){
        //             System.out.print(true + " ");
        //         } else{
        //             System.out.print(false + " ");
        //         }
        //     }
        //     System.out.println();
        // }

        go(r,c);
        System.out.println(ans);

        
    }

    public static void go(int y, int x){
        cnt++;
        if (cnt >= 4 * n){
            ans = -1;
            return;
        }
        // System.out.println(y + " " + x + " " +dir);
        int ny = y + dy[dir];
        int nx = x + dx[dir];

        if (out(ny, nx)) {
            ans++;
            return;
        }

        if (board[ny][nx] == '#'){
            dir = (dir - 1);
            if ( dir < 0) {
                dir = 3;
            } 
            go(y,x);
            return;
        }


        int right_dir = (dir +1 ) % 4;
        if (board[ny + dy[right_dir]][nx + dx[right_dir]] == '#'){
            ans++;
            go(ny, nx);
            return;
        }

        ans += 2;
        dir = right_dir;
        go(ny + dy[right_dir], nx + dx[right_dir]);
        return;
    }

    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || n <= x);
    }
}