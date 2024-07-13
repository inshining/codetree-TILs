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
            for (int j = 0; j <N; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++){
                int total = 0;
                for (int i = 0; i <3; i++){
                    for (int j = 0; j < 3; j++){
                        if (y + i >= N || x +j >= N){
                            continue;
                        }
                        total += board[y+i][x+j];

                    }
                } 

                ans = Math.max(ans, total);
            }
        }
        System.out.println(ans);
    }
}