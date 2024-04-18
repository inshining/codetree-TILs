import java.util.*;
public class Main {
    public static int n;
    public static int k;
    public static int[] arr = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int ans = Integer.MIN_VALUE;
        int num;
        for (int i = 0; i <= n-k; i++){
            num = 0;
            for (int j=0; j < k; j++ ){
                num += arr[i+j];
            }
            ans = Math.max(ans, num);
        }
        System.out.println(ans);
    }
}