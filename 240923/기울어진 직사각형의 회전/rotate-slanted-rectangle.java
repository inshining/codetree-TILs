import java.util.*;

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

        int r = sc.nextInt();
        int c = sc.nextInt();
        r--;
        c--;

        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int M = m1+m2+m3+m4;
        int[] dis = new int[]{m1, m2, m3,m4};

        int dir = sc.nextInt();

        int[] temp = new int[m1 + m2+ m3+m4];
        
        int[] dy = new int[]{-1, -1, 1, 1};
        int[] dx = new int[]{1, -1, -1, 1};
        int idx = 0;
        int ny = r;
        int nx = c;
        for (int i = 0; i < 4; i++){
            int num = dis[i];

            for (int j = 0; j < num; j++){
                ny = ny + dy[i];
                nx = nx + dx[i];

                // System.out.println(ny + " " + nx);
                // System.out.println(board[ny][nx]);
                temp[idx++] = board[ny][nx];
            }
        }

        int[] temp2 = new int[M];

        if (dir == 0){
            for (int i = 0; i < M -1; i++){
                temp2[i+1] = temp[i];
            }
            temp2[0] = temp[M-1];
        } else{
            for (int i = 0; i < M -1; i++){
                temp2[i] = temp[i+1];
            }
            temp2[M-1] = temp[0];
        }

        ny = r;
        nx = c;
        idx = 0;
        for (int i = 0; i < 4; i++){
            int num = dis[i];

            for (int j = 0; j < num; j++){
                ny = ny + dy[i];
                nx = nx + dx[i];

                // System.out.println(ny + " " + nx);
                // System.out.println(board[ny][nx]);
                board[ny][nx] = temp2[idx++];
            }
        }
        for (int i =0 ; i < N; i++){
            System.out.println(Arrays.toString(board[i]).replace(",", "").replace("[", "").replace("]",""));
        }
    }
}