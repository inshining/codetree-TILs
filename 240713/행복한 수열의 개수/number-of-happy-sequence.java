import java.util.*;
public class Main {
    public static int N, M;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j <N; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++){
            int pre = 0;
            int cnt= 1;
            for (int j = 0; j<N; j++){
                if (board[i][j] == pre){
                    cnt++;
                } else{
                    cnt = 1;
                }
                pre = board[i][j];
                if (cnt >= M){
                    ans++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++){
            int pre = 0;
            int cnt= 1;
            for (int j = 0; j<N; j++){
                if (board[j][i] == pre){
                    cnt++;
                } else{
                    cnt = 1;

                }
                pre = board[j][i];
                if (cnt >= M){
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
        
    }
}