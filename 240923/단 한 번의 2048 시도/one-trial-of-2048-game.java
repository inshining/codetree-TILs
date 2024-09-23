import java.util.*;

public class Main {
    public static int[][] board = new int[4][4];
    public static int N;
    public static char D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = 4;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                board[i][j] = sc.nextInt();
            }
        }

        D = sc.next().charAt(0);

        go();
            // int[] temp = new int[]{2, 2, 2, 4};
            // int idx = 0;
            // int[] temp2 = new int[N];
            // for (int i = 0; i < N; i++){
            //     if (i < N -1 && temp[i] == temp[i+1]){
            //         temp2[idx++] = temp[i] * 2;
            //         i++;
            //     } else if(temp[i] > 0){
            //         temp2[idx++] = temp[i];
            //     }
            // }
        for (int i = 0; i < N; i++){
            System.out.println(Arrays.toString(board[i]).replace(",", "").replace("[", "").replace("]",""));

        }
    }

    public static void go(){
        int[][] temp = new int[N][N];

        if (D == 'R'){
            for (int i = 0; i < 4; i++){
                int idx = 0;

                for (int j = N-1; j >= 0; j--){
                    if (board[i][j] > 0)
                        temp[i][idx++] = board[i][j];
                }
            }
        
        } else if(D == 'L'){
            for (int i = 0; i < N; i++){
                int idx = 0;

                for (int j = 0; j < N; j++){
                    if (board[i][j] > 0)
                        temp[i][idx++] = board[i][j];
                }
            }
        } else if(D == 'U'){
            for (int i =0; i < N; i++){
                int idx = 0;
                for (int j = 0; j < N; j++){
                    if (board[j][i] > 0)
                        temp[i][idx++] = board[j][i];
                }
            }
        } else if(D == 'D'){
            for (int i = 0; i < N; i++){
                int idx = 0;
                for (int j = N-1; j >= 0; j--){
                    if (board[j][i] > 0)
                        temp[i][idx++] = board[j][i];
                }
            }
        }
        int[][] temp2 = new int[N][N];

        for (int i = 0; i < 4; i++){

            int idx = 0;
            for (int j = 0; j < N; j++){
                if (j < N -1 && temp[i][j] == temp[i][j+1]){
                    temp2[i][idx++] = temp[i][j] * 2;
                    j++;
                } else if(temp[i][j] > 0){
                    temp2[i][idx++] = temp[i][j];
                }
            }
        }

        if (D == 'D'){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    board[N-1-j][i] = temp2[i][j];
                }
            }
        } else if (D == 'U'){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    board[j][i] = temp2[i][j];
                }
            }
        } else if (D == 'R'){
            for (int i = 0; i < N; i++){
                for (int j = 0;j < N; j++){
                    board[i][N-1-j] = temp2[i][j];
                }
            }
        } else{
            for (int i = 0; i < N; i++){
                for (int j = 0;j < N; j++){
                    board[i][j] = temp2[i][j];
                }
            }     
        }
    }
}