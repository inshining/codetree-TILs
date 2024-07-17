import java.util.*;

public class Main {
    public static int n, m, q;
    public static int[][] board;
    public static int[][] qs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        board = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        qs = new int[q][4];
        for (int i = 0; i < q; i++){
            for (int j = 0; j < 4; j++){
                qs[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < q; i++){
            go(qs[i][0], qs[i][1], qs[i][2], qs[i][3]);
            everage(qs[i][0], qs[i][1], qs[i][2], qs[i][3]);
        }
        
        for (int i = 0; i < n; i++){
            print(board[i]);
        }

    }

    public static void go(int r1, int c1, int r2, int c2){
        r1 -= 1;
        c1 -= 1;
        r2 -= 1;
        c2 -= 1;

        int[] upper = new int[c2-c1+1];
        int[] right = new int[r2 - r1 -1];
        int[] down = new int[c2-c1+1];
        int[] left = new int[r2 - r1 -1];

        if (r2 -r1 - 1 <= 0){
            noColum(r1, c1, r2, c2);
            return;
        }
        // 임시로 옮기고 마지막 요소는 다른 쪽 첫번째로 가기 
        for (int i = 0; i < c2 - c1; i++){
            upper[i+1] = board[r1][c1+i];
        }
        right[0] = board[r1][c2];
        
        for (int i = 0; i < r2 - r1 -2; i++){
            right[i+1] = board[r1+i][c2];
        }
        down[c2-c1] = board[r2-1][c2];
        for (int i = 0; i < c2- c1; i++){
            down[i] = board[r2][c1+i+1];
        }
        left[0] = board[r2][c1];
        for (int i = 1; i < r2 - r1 -1; i++){
            left[i] = board[r2-1-i][c1];
        }
        upper[0] = board[r1+1][c1];

        for (int i = 0; i < c2-c1+1; i++){
            board[r1][c1+i]  = upper[i];
        }
        for (int i = 0; i < r2 - r1 -1; i++){
            board[r1+1+i][c2] = right[i];
        }
        for (int i = 0; i < c2-c1+1; i++){
            board[r2][c1+i] = down[i];
        }

        for (int i = 0; i < r2 -r1 -1; i++){
            board[r2-1-i][c1] = left[i];
        }

    }

    public static void noColum(int r1, int c1, int r2, int c2){
        int[] upper = new int[c2-c1+1];
        int[] down = new int[c2-c1+1];

        // 임시로 옮기고 마지막 요소는 다른 쪽 첫번째로 가기 
        for (int i = 0; i < c2 - c1; i++){
            upper[i+1] = board[r1][c1+i];
        }
        down[c2-c1] = board[r1][c2];
        for (int i = 0; i < c2- c1; i++){
            down[i] = board[r2][c1+i+1];
        }
        upper[0] = board[r2][c1];

        for (int i = 0; i < c2-c1+1; i++){
            board[r1][c1+i]  = upper[i];
        }
 
        for (int i = 0; i < c2-c1+1; i++){
            board[r2][c1+i] = down[i];
        }

    }


    public static void everage(int r1, int c1, int r2, int c2){
        r1 -= 1;
        c1 -= 1;
        r2 -= 1;
        c2 -= 1;
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                temp[i][j] = board[i][j];
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                int num =1;
                int total = board[i][j];
                for (int d = 0; d < 4; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    if (out(ny, nx)){
                        continue;
                    }
                    num++;
                    total += board[ny][nx];

                }

                temp[i][j] = total / num;

            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
    public static boolean out(int y, int x){
        return (y < 0 || n <= y || x < 0 || m <= x);
    }
    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr).replace(",","").replace("[", "").replace("]", ""));
    }
}