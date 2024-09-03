import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] B = new char[n];

        for (int i = 0; i < n; i++){
            String k = sc.next();
            B[i] = k.charAt(0);
        }

        int[] H = new int[n];
        int[] S = new int[n];
        int[] P = new int[n];

        int[] LH = new int[n];
        int[] LS = new int[n];
        int[] LP = new int[n];

        int[] RH = new int[n];
        int[] RS = new int[n];
        int[] RP = new int[n];

        for (int i = 0; i < n; i++){
            if (B[i] == 'H')
                P[i] = 1;
            if (B[i] == 'S')
                H[i] = 1;
            if (B[i] == 'P')
                S[i] = 1;
        }

        LH[0] = H[0];
        LS[0] = S[0];
        LP[0] = P[0];

        RH[n-1] = H[n-1];
        RS[n-1] = S[n-1];
        RP[n-1] = P[n-1];

        for (int i = 1; i < n; i++){
            LH[i] = LH[i-1] + H[i];
            LS[i] = LS[i-1] + S[i];
            LP[i] = LP[i-1] + P[i];
        }

        for (int i = n-2; i >= 0; i--){
            RH[i] = RH[i+1] + H[i];
            RS[i] = RS[i+1] + S[i];
            RP[i] = RP[i+1] + P[i];
        }

        int ans = LH[n-1];
        ans = Math.max(ans, LS[n-1]);
        ans = Math.max(ans, LP[n-1]);

        for (int i = 0; i < n - 1; i++){
            int r = Math.max(RH[i+1], RS[i+1]);
            r = Math.max(r, RP[i+1]);
            
            int l = Math.max(LH[i], LS[i]);
            l = Math.max(l, LP[i]);

            ans = Math.max(ans, l + r);
        }
        System.out.println(ans);
    }
}