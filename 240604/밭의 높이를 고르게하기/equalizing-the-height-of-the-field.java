import java.util.*;
public class Main {
    public static int N, H, T;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        T = sc.nextInt();

        arr = new int[N];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <N; i++){
            arr[i] = Math.abs(sc.nextInt() - H);
        }

        for (int i = 0; i < N- T;i++){
            int num = 0;
            for (int j=i; j < i+T; j++){
                num += arr[j];
            }
            ans = Math.min(ans, num);
        }
        
        System.out.println(ans);
    }
}