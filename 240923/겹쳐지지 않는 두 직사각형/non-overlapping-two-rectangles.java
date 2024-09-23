import java.util.*;
import java.io.*; 

public class Main {
    public static int n, m, A, B;
    public static int[][] board;
    public static int[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int ans = go();
        System.out.println(ans);


    }

    public static void draw(int x1, int y1, int x2, int y2){
        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                visit[i][j]++;
            }
        }
    }

    public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        // visit = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                visit[i][j] = 0;
        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (visit[i][j] >= 2)
                    return true;
            }
        }
        return false;
    }

    public static int rectSum(int x1, int y1, int x2, int y2){
        int sum = 0;
        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                sum += board[i][j];
            }
        }
        return sum;
    }

    public static int go(int x1, int y1, int x2, int y2){
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        if (!overlapped(x1, y1, x2, y2, i, j, k,l)){
                            // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + i + " " + j + " " + k + " " + l);
                            maxSum = Math.max(maxSum, rectSum(x1, y1, x2, y2) + rectSum(i,j,k,l));
                        }
                    }
                }
            }
        }
        return maxSum;
    }

    public static int go(){
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++ ){
                    for (int l = j; l < m; l++){
                        maxSum = Math.max(maxSum, go(i,j,k,l));
                    }
                }
            }
        }
        return maxSum;
    }
}