import java.util.*;
public class Main {
    public static int N, K;
    public static int[] arr = new int[101];
    public static boolean isPossible(int val){
        int[] temp = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++){
            if (arr[i] <= val){
                temp[cnt++] = i;
            }
        }
        for (int i = 1; i < N; i++){
            if (temp[i] - temp[i-1] > K){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 101;
        for (int i = 100; i >= Math.max(arr[0], arr[N-1]);i--){
            if (isPossible(i)){
                ans = Math.min(ans, i);
            }
        }

        System.out.println(ans);
    }
}