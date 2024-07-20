import java.util.*;

public class Main {
    public static int n, m, k;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        k--;

        int y = findMaxRow();

        for (int i = 0; i < m; i++){
            board[y][i+k] = 1;
        }

        for (int i =0 ; i < n; i++){
            System.out.println(Arrays.toString(board[i]).replace(",", "").replace("[", "").replace("]", ""));
        }
        
    }

    public static int findMaxRow(){
        int ans = n;
        for (int i = 0; i < m; i++){
            int rowV = -1;
            for (int j = 0; j < n; j++){
                if (board[j][i+k] == 0){
                    rowV = j;
                } else{
                    break;
                }
            }
            ans = Math.min(ans, rowV);
        }
        return ans;
    }
}