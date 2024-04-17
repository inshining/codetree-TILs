import java.util.*;
public class Main {
    public static int[][] board = new int[19][19];
    public static int[] row = {-2, -1, 0, 1, 2};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 19; i++){
            for (int j = 0; j <19; j++){
                board[i][j] = sc.nextInt();
            }
        }
            
        int val;
        int ny, nx;
        int ay = -1;
        int ax = -1;
        int ans = 0;
        for (int i = 0; i < 19; i++){
            for (int j = 0; j <19; j++){
                val = board[i][j];


                if (val == 0) continue;
                
                for (int k = 0; k < 5; k++){
                    ny = i + row[k];
                    nx = j;
                    if (ny < 0 || 19 <= ny || nx < 0 || 19<=nx) break;
                    if (board[ny][nx] != val) break;
                    
                    if (k == 4){
                        ans = val;
                        ay = i;
                        ax = j;
                    }
                }

                for (int k = 0; k < 5; k++){
                    ny = i;
                    nx = j + row[k];
                    if (ny < 0 || 19 <= ny || nx < 0 || 19<=nx) break;

                    if (board[ny][nx] != val) break;
                    
                    if (k == 4){
                        ans = val;
                        ay = i;
                        ax = j;
                    }
                }

                for (int k = 0; k < 5; k++){
                    ny = i + row[k];
                    nx = j + row[k];

                    if (ny < 0 || 19 <= ny || nx < 0 || 19<=nx) break;
                    if (board[ny][nx] != val) break;
                    
                    if (k == 4){
                        ans = val;
                        ay = i;
                        ax = j;
                    }
                }

                for (int k = 0; k < 5; k++){
                    ny = i + row[4-k];
                    nx = j + row[k];
                    
                    if (ny < 0 || 19 <= ny || nx < 0 || 19<=nx) break;
                    if (board[ny][nx] != val) break;
                    
                    if (k == 4){
                        ans = val;
                        ay = i;
                        ax = j;
                    }
                }
                
            }
        }
        System.out.println(ans);
        if (ans != 0){
            ay++;
            ax++;
            System.out.println(ay + " " + ax);
        }
    }
}