import java.util.*;

public class Main {
    public static int n, ans; 
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        ans = 0;
        go(0);
        System.out.println(ans);
    }

    public static void go(int idx){
        if (idx > n){
            return;
        }
        if (idx == n){
            ans++;
            return;
        }
        for (int i = 1; i <= 4; i++){
            go(idx+i);
        }
    }
}