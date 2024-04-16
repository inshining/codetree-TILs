import java.util.*;
public class Main {
    public static int n;
    public static int[] arr = new int[101]; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i =0; i < n; i++) arr[i] = sc.nextInt();

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i+2; j <n; j++){
                ans = Math.max(ans, arr[i] + arr[j]);
            }
        }

        System.out.println(ans);
    }
}