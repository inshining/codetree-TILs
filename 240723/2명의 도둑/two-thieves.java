import java.util.*;

public class Main {
    public static int n,m, c, maxA, maxB, ans;
    public static int[][] board;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        arr = new int[2 * m];
        board = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        go(0,0,0);
        System.out.println(ans);
    }

    public static void go(int r, int c, int idx){
        if (idx >= 2){
            // System.out.println(Arrays.toString(arr));
            cal();
            return;
        }
        for (int y = r; y < n; y++ ){
            for (int x = 0; x < n; x++){
                if (y == r && x < c) continue;
                if (x > n - m) continue;

                for (int i = 0; i < m; i++){
                    arr[i + (m * idx)] = board[y][x+i];
                }
                go(y, x+m, idx+1);
            }
        }
    }

    public static void cal(){
        int[] vs = new int[m];
        maxA = 0;
        maxB = 0;
        getMaxV(0, 0, vs, 0);
        vs = new int[m];
        getMaxV(0, m, vs, 0);

        ans = Math.max(ans, maxA + maxB);
        // System.out.println(maxA + maxB);
        
    }

    public static void getMaxV(int idx, int base, int[] vs, int total){
        if (total > c){
            return;
        }
        if (idx >= m){
            int v = 0;
            for (int i = 0; i < m; i++){
                v += vs[i] * vs[i];
            }
            if (base == 0){
                maxA = Math.max(maxA, v);
            } else{
                maxB = Math.max(maxB, v);
            }
            return;
        }

        vs[idx] = arr[idx + base];
        getMaxV(idx+1, base, vs, total + arr[idx+base]);
        vs[idx] = 0;
        getMaxV(idx+1, base, vs, total);

    }
}