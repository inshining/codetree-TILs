import java.util.*;
class Pair{
    int y,x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visit;
    public static int[][] map;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visit = new boolean[n][m];
        map = new int[n][m];

        for (int i =0 ; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        push(0, 0);
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;

            for (int i =0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || n <= ny || nx < 0 || m <= nx) continue;
                if (board[ny][nx] == 0) continue;
                if (visit[ny][nx]) continue;

                map[ny][nx] = map[y][x] + 1;
                push(ny, nx);
            }
        }

        // for (int i =0 ; i < n; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        int ans = -1;
        if (visit[n-1][m-1]){
            ans = map[n-1][m-1];
        }
        System.out.println(ans);
    }

    public static void push(int y, int x){
        visit[y][x] = true;
        q.add(new Pair(y,x));
    }


}