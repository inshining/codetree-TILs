import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, go(-1, i, 2));
        }

        for (int i = 0; i < n; i++){
            ans = Math.max(ans, go(i, n, 3));
        }

        for (int i = 0; i < n; i++){
            ans = Math.max(ans, go(n, i, 0));
        }

        for (int i = 0; i < n; i++){
            ans = Math.max(ans, go(i, -1, 1));
        }
        System.out.println(ans);
    }

    public static int chageDir(int dir, int pos){
        if (pos == 1){
            HashMap<Integer, Integer> change = new HashMap<Integer, Integer>(){{
                put(0, 1);
                put(1, 0);
                put(2, 3);
                put(3, 2);
            }};

            return change.get(dir);
        } else if(pos == 2){
            HashMap<Integer, Integer> change = new HashMap<Integer, Integer>(){{
                put(0, 3);
                put(1, 2);
                put(2, 1);
                put(3, 0);
            }};
            return change.get(dir);
        }
        return 0;
    }

    public static int go(int y, int x, int d){
        int ny = y + dy[d];
        int nx = x + dx[d];

        int v = 1;

        while (!out(ny,nx)){
            // System.out.println(ny + " " + nx);
            if (board[ny][nx] > 0){
                d = chageDir(d, board[ny][nx]);
            }
            ny = ny + dy[d];
            nx = nx + dx[d];
            v++;
        }
        return v;
    }

    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || n <= x);
    }
}