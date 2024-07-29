import java.util.*;

public class Main {
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            int v = map.getOrDefault(k, 0);
            map.put(k, v+1);
        }

        for (int i =0; i < m; i++){
            int k = sc.nextInt();
            System.out.print(map.getOrDefault(k, 0)+ " ");
        }

    }
}