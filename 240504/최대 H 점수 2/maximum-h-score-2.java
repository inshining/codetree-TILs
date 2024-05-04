import java.util.*;
public class Main {
    public static int N, L;
    public static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        N = sc.nextInt();
        L = sc.nextInt();
        for (int i = 0; i < N; i++){
            k = sc.nextInt();
            arr[k]++;
        }
        int ans = 0;
        int plus = 0;
        for (int h = 0; h <= 100; h++){

            int num = 0;
            if (h > 0){
                num = Math.min(L, arr[h-1]);
            } 

            for (int i = h; i <= 100; i++){
                num += arr[i];
            }
            if (h <= num){
                ans = h;
            }
        }
        System.out.println(ans);
    }
}