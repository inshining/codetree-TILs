import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] maxV = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        maxV[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            maxV[i] = Math.max(arr[i], maxV[i+1]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, maxV[i] - arr[i]);
        }
        System.out.println(ans);
    }
}