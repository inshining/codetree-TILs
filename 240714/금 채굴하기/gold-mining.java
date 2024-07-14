import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M= sc.nextInt();

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++){
                for (int k = 0; k <= 2 * (N-1); k++){
                    int num = getNumOfMoney(y,x, k);
                    if (num * M >= getArea(k)){
                        ans = Math.max(ans, num);
                    }
                }
            }
        }
        System.out.println(ans);
    
    }
    public static boolean out(int y, int x){
        return (y < 0 || N <= y || x < 0 || N <= x);
    }

    public static int getArea(int k){
        return k * k + (k+1) * (k+1);
    }

    public static int getNumOfMoney(int y, int x, int k){
        
        int num = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (Math.abs(y - i) + Math.abs(x - j) <= k){
                    num += board[i][j];
                }
            }
        }
        return num;
    }

}