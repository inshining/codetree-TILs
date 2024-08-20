import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> t = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= m; i++){
            t.add(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            if (t.floor(arr[i]) != null){
                int num = t.floor(arr[i]);
                t.remove(num);
                ans++;
            } else break;
        }

        System.out.println(ans);

    }
}