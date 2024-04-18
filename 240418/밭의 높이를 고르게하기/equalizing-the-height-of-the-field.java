import java.util.*;
public class Main {
    public static int N, H, T;
    public static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        T = sc.nextInt();

        for (int i = 0; i < N; i++) 
            arr[i] = Math.abs(H - sc.nextInt());

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N-T; i++){
            int num = 0;
            for (int j = i; j < i+T; j++){
                num += arr[j];
            }
            ans = Math.min(ans, num);
        }
        System.out.println(ans);
    }
}