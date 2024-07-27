import java.util.*;

class Pair{
    int y,x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;

    }
}
public class Main {
    public static int n, k;
    public static int[][] board, map;
    public static boolean[][] visit;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][n];
        visit = new boolean[n][n];
        map = new int[n][n];

        for (int i =0; i < n; i++){
            for (int j =0; j < n; j++){
                board[i][j] = sc.nextInt();
                if (board[i][j]  == 2){
                    push(i,j);
                }
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for (int i =0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
                if (visit[ny][nx]) continue;
                if (board[ny][nx] == 1){
                    push(ny, nx);
                    map[ny][nx] = map[y][x] + 1;
                }
            }
        }

        for (int i =0; i < n; i++){
            for (int j =0; j < n; j++){
                if (map[i][j] == 0 && board[i][j] == 0) map[i][j] = -1;
                if ((map[i][j] == 0) && (!visit[i][j]) && board[i][j] == 1) map[i][j] = -2;
            }
        }

        for (int i =0; i < n; i++){
            System.out.println(Arrays.toString(map[i]).replace("[", "").replace(",", "").replace("]", ""));
        }
    }

    public static void push(int y, int x){
        visit[y][x] = true;
        q.add(new Pair(y,x));
    }
}