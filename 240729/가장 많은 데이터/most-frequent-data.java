import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            String k = sc.next();
            int v = map.getOrDefault(k, 0);
            map.put(k, v+1);
        }

        int ans = 0;
        for (int v : map.values()){
            ans = Math.max(ans, v);
        }
        // int ans = Arrays.stream(map.values()).max();
        System.out.println(ans);
    }
}