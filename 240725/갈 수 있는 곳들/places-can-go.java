import java.util.*;

class Pair{
    int y,x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static Queue<Pair> q = new LinkedList<>();
    public static int n, k;
    public static int[][] board;
    public static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();    

        board = new int[n][n];
        visit = new boolean[n][n];

        for (int i =0; i < n; i++){
            for (int j =0 ; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            y -= 1;
            x -= 1;
            push(y,x);
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x= p.x;

            for (int i =0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || n <= ny || nx < 0 || n <= nx) continue;
                if (board[ny][nx] == 1) continue;
                if (visit[ny][nx]) continue;

                push(ny,nx);
            }    
        }

        int ans =0 ;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visit[i][j]) ans++;
            }
        }

        System.out.println(ans);
    }

    public static void push(int y, int x){
        visit[y][x] = true;
        q.add(new Pair(y,x));
    }
}