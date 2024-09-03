import java.util.*;

class Pair{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Pair[] ps = new Pair[n];

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            Pair p = new Pair(x, y);
            ps[i] = p;
            
        }

        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 1; i < n; i++){
            int d = Math.abs(ps[i].x - ps[i-1].x) + Math.abs(ps[i].y - ps[i-1].y);
            L[i] = L[i-1] + d;
        }

        for (int i = n-2; i >= 0; i--){
            int d = Math.abs(ps[i].x - ps[i+1].x) + Math.abs(ps[i].y - ps[i+1].y);
            R[i] = R[i+1] + d;
        }

        // for (int i = 0; i < n; i++){
        //     System.out.print(L[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < n; i++){
        //     System.out.print(R[i] + " ");
        // }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++){
            int d = Math.abs(ps[i-1].x - ps[i+1].x) + Math.abs(ps[i-1].y - ps[i+1].y);

            ans = Math.min(ans, L[i-1] + R[i+1] + d);
        }
        System.out.println(ans);
    }
}