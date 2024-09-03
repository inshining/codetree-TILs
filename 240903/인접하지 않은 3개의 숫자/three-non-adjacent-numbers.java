import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }

        L[0] = A[0];
        R[n-1] = A[n-1];

        for (int i = 1; i < n; i++){
            L[i] = Math.max(L[i-1], A[i]);
        }

        for (int i = n-2; i >= 0; i--){
            R[i] = Math.max(R[i+1], A[i]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 2; i < n-2; i++){
            int k = A[i] + L[i-2] + R[i+2];
            ans = Math.max(ans, k);
        }

        System.out.println(ans);
    }
}