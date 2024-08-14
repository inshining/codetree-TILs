import java.util.*;

public class Main {
    public static int n, m, ans;
    public static String[] A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        A = new String[n];
        B = new String[n];
        for (int i = 0; i < n; i++){
            A[i] = sc.next();
        }

        ans= 0;

        for (int i = 0; i < n; i++) B[i] = sc.next();

        for (int x = 0; x < m; x++){
            for (int y = x+1; y < m; y++){
                for (int z = y+1; z < m; z++){
                    if (go(x,y,z)) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean go(int x, int y, int z){
        HashSet s = new HashSet();

        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(A[i].substring(x, x+1)).append(A[i].substring(y, y+1)).append(A[i].substring(z, z+1));
            s.add(sb.toString());
        }

        // System.out.println(s);

        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(B[i].substring(x, x+1)).append(B[i].substring(y, y+1)).append(B[i].substring(z, z+1));
            if (s.contains(sb.toString())) return false;
        }
        return true;
    }
}