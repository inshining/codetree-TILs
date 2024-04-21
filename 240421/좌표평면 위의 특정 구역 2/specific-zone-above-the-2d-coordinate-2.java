import java.util.*;
public class Main {
    public static int N;
    public static int[][] arr = new int[101][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++){
            int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
            for (int j=0; j <N; j++){
                if (i==j){
                    continue;
                }

                int x = arr[j][0], y = arr[j][1];
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);

                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
            ans = Math.min(ans, (maxX - minX) * (maxY-minY));
        }

        System.out.println(ans);
    }
}