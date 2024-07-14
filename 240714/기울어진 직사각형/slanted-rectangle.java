import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j =0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }    
        int ans = 0;
        for (int i = 0; i < N; i++){
            for (int j =0; j < N; j++){
                for (int k = 1; k < N; k++){
                    for (int l = 1; l < N; l++){
                        ans = Math.max(ans, go(i,j,k,l));
                    }
                }
            }
        }
        System.out.println(ans);


    }

    public static boolean out(int y, int x){
        return (y < 0 || N <= y || x < 0 || N <= x);
    }

    public static int go(int y, int x, int k, int l){
        int[] dy = {-1, -1, 1, 1};
        int[] dx = {1, -1, -1, 1};
        int[] moveNum = {k, l, k, l};

        int total = 0;

        for (int d = 0; d < 4; d++){
            for (int q = 0; q < moveNum[d]; q++){
                y += dy[d]; x += dx[d];

                if (out(y,x)){
                    return 0;
                }
                total += board[y][x];
            }
        }

        return total; 
    }
}