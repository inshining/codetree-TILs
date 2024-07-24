import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n+1][n+1];
        visit = new boolean[n+1];

        for (int i =0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            board[start][end] = 1;
            board[end][start] = 1;
        }

        dfs(1);
        int ans = 0;
        for (int i =1; i <= n; i++){
            if (visit[i]) ans++;
        }
        System.out.println(ans-1);

    }

    public static void dfs(int k){
        for (int i = 1; i <= n; i++){
            if (board[k][i] == 1 && !visit[i]){
                visit[i] = true;
                dfs(i);
            }
        }
    }
}