import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (map.containsKey(x)){
                int v = map.get(x);
                map.put(x, Math.min(v, y));
            } else{
                map.put(x, y);
            }

        }
        int ans = 0;
        for (int k : map.keySet()){
            ans += map.get(k);
        }
        // int ans = map.values().stream().sum();
        System.out.println(ans);
    }
}