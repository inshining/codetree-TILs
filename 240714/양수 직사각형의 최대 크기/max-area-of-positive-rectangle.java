import java.util.*;
import java.io.*; 

public class Main {
    public static int N, M;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int ans = go();
        System.out.println(ans);

    }

    public static boolean out(int y, int x){
        return (y < 0 || N <= y || x < 0 || M <= x);
    }

    public static int go(){
        int result = -1;
        for (int y =0; y < N; y++){
            for (int x = 0; x < M; x++){
                for (int sy = 1; sy <= N; sy++){
                    for (int sx = 1; sx <= M; sx++){
                        // System.out.println(cal(y,x,sy,sx));
                       result = Math.max(result, cal(y,x,sy,sx));
                    }
                }
            }
        }
        return result;
    }

    public static int cal(int y, int x, int k, int l){
        int total = 0;
        for (int dy = 0; dy < k; dy++){
            for (int dx = 0; dx < l; dx++){
                if (out(y + dy, x + dx)){
                    return -1;
                }
                if (board[y+dy][x+dx] <= 0){
                    return -1;
                }
                total += 1;
            }
        }
        return total;
    }

}