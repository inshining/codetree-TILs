import java.util.*;
public class Main {
    public static int n, m, t;
    public static int[][] board;
    public static int[][] marbles;
    public static int[][] nextBoard;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        marbles = new int[m+1][4];
        for (int i = 1; i <= m; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            int d = (int) sc.next().charAt(0);
            int w = sc.nextInt();
            y -= 1;
            x -= 1;
            marbles[i] = new int[]{y, x, d, w};
        }

        for (int i = 0; i < t; i++){
            nextBoard = new int[n][n];

            for (int idx = 1; idx <= m; idx++){
                if (marbles[idx][0] == -1 && marbles[idx][1] == -1) continue;
                move(idx);
            }

            for (int y = 0; y < n; y++){
                for (int x = 0; x < n; x++){
                    if (nextBoard[y][x] > 0){
                        int idx = nextBoard[y][x];
                        // System.out.println(idx);
                        updatePos(idx, y, x);
                    }
                }
            }

            // for (int idx =1 ; idx <= m; idx++){
            //     System.out.println(Arrays.toString(marbles[idx]));
            // }
            // for (int k =0 ; k < n; k++){
            // System.out.println(Arrays.toString(nextBoard[k]));
            // }
        }

        int cnt = 0;
        int maxV = 0;
        for (int i = 1; i <= m; i++){
            if (marbles[i][0] == -1) continue;
            cnt++;
            maxV = Math.max(maxV, marbles[i][3]);
        }

        System.out.println(cnt + " " + maxV);
    }

    public static void move(int idx){
        int r= marbles[idx][0];
        int c = marbles[idx][1];
        char d = (char) marbles[idx][2];
        int w = marbles[idx][3];

        int ny = r;
        int nx = c;

        if ( d == 'U'){
            ny -= 1;
        } else if( d == 'L'){
            nx -= 1;
        } else if (d == 'D'){
            ny += 1;
        } else if (d == 'R'){
            nx += 1;
        }

        if (ny < 0 || n <= ny || nx < 0 || n <+ nx){
            chageDir(idx);
            nextBoard[r][c] = idx;
            return;
        }

        if (nextBoard[ny][nx] > 0){
            int other = nextBoard[ny][nx];
            int winner = collis(idx, other);
            nextBoard[ny][nx] = winner;
        } else{
            nextBoard[ny][nx] = idx;
        }
    }

    public static int collis(int idx, int other){
        int winner = Math.max(idx, other);
        int loser = Math.min(idx, other);

        marbles[loser][0] = -1;
        marbles[loser][1] = -1;

        marbles[winner][3] += marbles[loser][3];
        return winner;
    }

    public static void chageDir(int idx){
        char dir = (char) marbles[idx][2];
        if (dir == 'U'){
            dir = 'D';
        } else if(dir == 'D'){
            dir = 'U';
        } else if(dir == 'L'){
            dir = 'R';
        } else if(dir == 'R'){
            dir = 'L';
        }
        marbles[idx][2] = (int) dir;
    }

    public static void updatePos(int idx, int y, int x){
        marbles[idx][0] = y;
        marbles[idx][1] = x;
        
    }
}