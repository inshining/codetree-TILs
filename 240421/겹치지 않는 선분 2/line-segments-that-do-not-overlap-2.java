import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr = new int[101][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i =0; i <N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < N; i++){
            boolean isOver = false;
            for (int j=0; j<N; j++){
                if (i ==j) continue;

                if ((arr[i][0] <= arr[j][0] && arr[j][1] <= arr[i][1]) || (arr[j][0] <= arr[i][0] && arr[i][1] <= arr[j][1])){
                    isOver = true;
                    break;
                }
            }
            if (isOver == false){
                ans++;
            }
        }
        System.out.println(ans);
    }
}