import java.util.*;
public class Main {
    public static int N, K;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int ans=10000;
        for (int start = 1; start <= 10000; start++){
            int total = 0;
            for (int i=0; i < N;i++){
                if (arr[i] < start){
                    total += Math.abs(arr[i] - start);
                } else if(start + K < arr[i]){
                    total += Math.abs(start + K - arr[i]);
                }
            }
            ans = Math.min(ans, total);
        }
        System.out.println(ans);
    }
}