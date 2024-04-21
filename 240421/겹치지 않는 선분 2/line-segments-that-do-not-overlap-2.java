import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr = new int[101][2];
    public static int[] isOver = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i =0; i <N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++){
            int startX = arr[i][0];
            int endX = arr[i][1];

            for (int j=0; j<N; j++){
                if (i ==j) continue;

                int bStartX = arr[j][0];
                int bEndX = arr[j][1];

                if ((startX <= bStartX && bStartX <= endX) && (startX <= bEndX && bEndX <= endX)){
                    isOver[i] = 1;
                    isOver[j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++){
            if (isOver[i] == 0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}