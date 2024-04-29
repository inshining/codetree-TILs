import java.util.*;

public class Main {
    public static int N, M;
    public static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i < N+1; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 1; i < N; i++){
            int temp = 0;
            int num = i;
            for (int j = 0; j < M; j++){
                temp += arr[num];
                num = arr[num];

            }
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}