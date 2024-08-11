import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            int v = map.getOrDefault(a, 0);
            map.put(a, v + 1);
        }

        int ans = 0;
        for (int key : map.keySet()){
            int v = map.get(key);
            v *= map.getOrDefault(k - key, 0);
            ans += v;
        }
        ans /= 2;
        System.out.println(ans);
    }
}