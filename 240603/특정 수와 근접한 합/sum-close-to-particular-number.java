import java.util.*;
public class Main {
    public static int N, S;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        int total = 0;
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            for (int j = i+1; j <N; j++){
                ans = Math.min(ans, Math.abs(S - (total - arr[i] - arr[j])));
            }
        }
        System.out.println(ans);
    }
}