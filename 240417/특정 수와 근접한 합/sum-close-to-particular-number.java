import java.util.*;
public class Main {
    public static int[] arr = new int[101];
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int S = sc.nextInt();

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int e : arr) sum += e;
        int temp;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                temp = sum - arr[i] - arr[j];
                ans = Math.min(ans, Math.abs(S- temp));
            }
        }
        System.out.println(ans);
    }
}