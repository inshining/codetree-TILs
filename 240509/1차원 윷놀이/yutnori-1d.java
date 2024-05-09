import java.util.*;
public class Main {
    public static int N, M, K;
    public static int[] board;
    public static int[] mal;
    public static int ans;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        board = new int[N];
        mal = new int[K];
        for (int i = 0; i < N; i++){
            board[i] = sc.nextInt();
        }
        go(0);
        System.out.println(ans);

    }
    public static void go(int idx){
        if (idx >= N){
            int num = 0;
            for (int i = 0; i < K; i++){
                if (mal[i] >= M -1){
                    num++;
                }
            }
            ans = Math.max(ans, num);
            return;
        }
        int v = board[idx];
        for (int i = 0; i < K; i++){
            mal[i] += v;
            go(idx+1);
            mal[i] -= v;
        }
    }
}