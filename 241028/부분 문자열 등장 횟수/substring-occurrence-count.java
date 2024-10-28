import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        String p = sc.next();

        int n = t.length();
        int m = p.length();

        t = "#" + t;
        p = "#" + p;

        int[] f= new int[m+1];

        f[0] = -1;
        for(int i = 1; i <= m; i++){
            int j = f[i-1];
            while(j >= 0 && p.charAt(j+1) != p.charAt(i))
                j = f[j];
            f[i] = j+1;
        }
        int j = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            while(j >= 0 && p.charAt(j+1) != t.charAt(i))
                j = f[j];
            j++;
            if(j==m){
                ans++;
                j = f[j];
            }
        }
        System.out.println(ans);
    }
}