import java.util.*;
public class Main {
    public static int N, ans;
    public static int[][] board;
    public static boolean[] visit;
    public static int[] pos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visit = new boolean[N];
        for(int i = 0; i <N; i++){
            for (int j = 0; j <N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        pos = new int[N];
        go(0);
        System.out.println(ans);
        
    }
    public static void go(int idx){
        if (idx >= N){
            int total = 0;
            for (int i = 0; i < N; i++){
                total += board[i][pos[i]];
            }
            ans = Math.max(ans, total);

            return;
        }

        for (int i = 0; i < N; i++){
            if (visit[i]){
                continue;
            }
            visit[i] = true;
            pos[idx] = i;
            go(idx+1);
            visit[i] = false;
        }
    }
}