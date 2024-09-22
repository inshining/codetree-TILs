import java.util.*;


public class Main {
    public static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int cnt = 0;
                for (int r = 0; r < 3; r++){
                    for (int c = 0; c < 3; c++){
                        if (i + r < n && j + c < n){
                            cnt += map[i+r][j+c];
                        }
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);
        
    }
}