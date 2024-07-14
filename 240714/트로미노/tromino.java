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
            for (int j = 0; j <M; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i <N; i++){
            for (int j = 0; j < M; j++){
                ans = Math.max(ans,getBar(i, j));
                ans = Math.max(ans,getRec(i, j));
   
            }
        }
        System.out.println(ans);

    }

    public static boolean out(int y, int x){
        return (y < 0  ||  N <= y || x < 0 || M <= x );
    }

    public static int getRec(int y, int x){
        int a = 0 , b = 0, c= 0, d=0;
        if (! out(y,x)){
            a = board[y][x];
        }
        if (!out(y, x+1)){
            b = board[y][x+1];
        }

        if (!out(y+1, x)){
            c = board[y+1][x];
        }

        if (!out(y+1, x+1)){
            d = board[y+1][x+1];
        }
        int total = a+b+c+d;

        int result = Math.max(total - a, total - b);
        result= Math.max(result,  total - c);
        result= Math.max(result,  total - d);

        return result;
    }

    public static int getBar(int y, int x){
        int result = 0;
        int temp = 0;
        for (int i = 0; i <3; i++){
            if (out(y, x+i)){
                temp = 0;
                break;
            }
            temp += board[y][x+i];
        }

        result = Math.max(result, temp);
        temp = 0;
        for (int i = 0; i <3; i++){
            if (out(y+i, x)){
                temp = 0;
                break;
            }
            temp += board[y+i][x];
        }
        result = Math.max(result, temp);
        return result;
    }
}