import java.util.*;
public class Main {
    public static int N;
    public static int[] board;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        for (int i = 0; i < N; i++){
            board[i] = sc.nextInt();
        }

        go(0, 0);
        if (ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);

    }

    public static void go(int idx, int cnt){
        if (idx >= N-1){
            ans = Math.min(ans, cnt);
            return;
        }
        int num = board[idx];

        for (int i = 1; i <= num; i++){
            go(idx + i, cnt+1);
        }
    }
}