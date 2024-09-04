import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] L = new int[n];
        if (s.charAt(0) == 'C'){
            L[0] = 1;
        }
        int[] R = new int[n];
        for (int i = 1; i < n; i++){

            L[i] = L[i-1];
            if (s.charAt(i) == 'C'){
                L[i] += 1;
            }
        }

        if (s.charAt(n-1) == 'W'){
            R[n-1] = 1;
        }
        for (int i = n-2; i>=0; i--){
            R[i] = R[i+1];
            if (s.charAt(i) == 'W')
                R[i] += 1;
        }

        long ans = 0;
        for (int i = 1; i < n-1; i++){
            if (s.charAt(i) == 'O')
                ans += (long) (L[i-1] * R[i+1]);
        }
        System.out.println(ans);
    }
}