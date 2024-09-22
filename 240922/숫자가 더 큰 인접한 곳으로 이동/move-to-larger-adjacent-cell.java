import java.util.*;

public class Main {
    public static int[] dy = new int[]{-1, 1, 0, 0};
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[][] map;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        r --;
        c --;

        map = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        go(r,c);

    }

    public static void go(int y, int x){
        System.out.print(map[y][x] + " ");

        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < n && 0 <= nx && nx < n){
                if (map[y][x] < map[ny][nx]){
                    go(ny,nx);
                    return;
                }
            }
        }
    }
}