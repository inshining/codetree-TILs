import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int idx;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int num = 0;
            for (int j = 0; j < n; j++){
                idx = (i+j) % n;
                num += arr[idx] * j;
            }
            ans = Math.min(ans, num);
        }
        System.out.println(ans);
    }
}