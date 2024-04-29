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
            int[] copy = new int[N+1];
            for (int j =1; j < N+1; j++){
                copy[j] = arr[j];
            }
            for (int j = 0; j < M; j++){
                if (num == copy[num]) break;
                temp += copy[num];
                int mem = copy[num];
                copy[num] = num;
                num = mem;

            }
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}