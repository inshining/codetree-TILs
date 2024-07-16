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

        qs = new int[q][2];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < q; i++){
            qs[i][0] = sc.nextInt() - 1;
            String s = sc.next();
            if (s.equals("L")){
                qs[i][1] = 0;
            } else if(s.equals("R")){
                qs[i][1] = 1;
            }
        }

        for (int i = 0; i < q; i++){
            int idx = qs[i][0];
            go(idx, qs[i][1]);
            comp(idx, -1, qs[i][1]);
            comp(idx, 1, qs[i][1]);
        }

        for (int i = 0; i < n; i++){
            System.out.println(Arrays.toString(board[i]).replace(",", "").replace("[","").replace("]", "").trim());
        }

    }

    public static void go(int idx, int dir){
        int[] arr = board[idx];
        int[] temp = new int[m];
        if (dir == 0){
            for (int i = 0; i < m-1; i++){
                temp[i+1] = arr[i];
            }
            temp[0] = arr[m-1];
        } else if(dir == 1){
            for (int i = 0; i < m-1; i++){
                temp[i] = arr[i+1];
            }
            temp[m-1] = arr[0];
        }
        for (int i = 0; i < m; i++){
            board[idx][i] = temp[i];
        }
    }

    public static void comp(int orign, int which, int dir){
        int com = orign + which;
        if (com < 0 || n <= com){
            return;
        }

        boolean check = false;
        for (int i = 0; i < m; i++){
            if (board[orign][i] == board[com][i]){
                check = true;
                break;
            }
        }

        if (!check){
            return;
        }

        dir = (dir + 1) % 2;
        go(com, dir);

        comp(com, which, dir);
    }
}