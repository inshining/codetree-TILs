import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] pre = new int[n+1];

        for (int i = 0; i < n; i++){
            pre[i+1] = pre[i] + sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j <= n; j++){
                if (k == (pre[j] - pre[i])){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}