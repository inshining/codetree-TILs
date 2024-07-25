import java.util.*;

class Pair{
    int y,x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Main {
    public static int n, k, u, d, ans;
    public static int[][] board;
    public static boolean[][] visit;
    public static Queue<Pair> q = new LinkedList<>();
    public static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        board = new int[n][n];

        for (int i =0 ; i < n; i++){
            for (int j = 0;j <n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int idx, int y, int x){
        if (idx >= k){

            int cnt = bfs();

            ans = Math.max(ans, cnt);

            return;
        }

        for (int i = y; i < n; i++){
            for (int j =0; j < n; j++){
                if (i == y && j < x) continue;
                list.add(new Pair(i, j));
                dfs(idx+1, i, j+1);
                list.remove(list.size() -1);
            }
        }
        
    }

    public static int bfs(){
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        visit = new boolean[n][n];

        for (Pair p : list){
            push(p.y, p.x);
        }

        while (!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || n <= ny || nx < 0 || n <= nx)continue;
                if (visit[ny][nx]) continue;
                int diff = Math.abs(board[p.y][p.x] - board[ny][nx]);
                if (u <= diff && diff <= d){
                    push(ny,nx);
                }
            }

        }

        int cnt = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (visit[i][j]) cnt++;
                }
        }
        return cnt;
    }

    public static void push(int y, int x){
        visit[y][x] = true;
        q.add(new Pair(y,x));
    }
}