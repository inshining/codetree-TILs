import java.util.*;
class Pair{
    int y, x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Main {
    public static int n, r1, c1, r2, c2;
    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visit;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();

        r2 = sc.nextInt();
        c2 = sc.nextInt();

        r1 -= 1;
        c1 -= 1;
        r2 -= 1;
        c2 -= 1;

        board = new int[n][n];
        visit = new boolean[n][n];

        push(r1, c1);

        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        while (!q.isEmpty()){
            Pair p = q.poll();
            int y= p.y;
            int x= p.x;

            if (y == r2 && x == c2) break;

            for (int i =0; i < 8; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
                if (visit[ny][nx]) continue;
                board[ny][nx] = board[y][x] +1;
                push(ny,nx);
            }
        }

        int ans = -1;

        if (visit[r2][c2]) ans = board[r2][c2];

        System.out.println(ans);
    }

    public static void push(int y, int x){
        visit[y][x] = true;
        q.add(new Pair(y,x));
    }
}