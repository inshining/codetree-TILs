import java.util.*;

public class Main {
    public static int ans, total, n;
    public static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l = new ArrayList<>();

        n = sc.nextInt();
        for (int i =0; i < n; i++){
            l.add(sc.nextInt());
        }

        ans = Integer.MIN_VALUE;

        Collections.sort(l);

        arr = new ArrayList<>();
        arr.add(0);

        for (int i = 0; i < n; i++){
            int v = arr.get(arr.size() - 1) + l.get(i);
            arr.add(v);
        }
        total = arr.get(arr.size() - 1);
        // System.out.println(arr);
        // go(1);
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int v = arr.get(j) - arr.get(i); 
                int min = Math.min(v, total - v);
                ans = Math.max(ans, min);
            }
        }
        System.out.println(ans);
    }

    public static void go(int dis){
        if (dis >= n)
            return;

        for (int i = 0; i < arr.size() - dis; i++){
 
        }

        go(dis+1);
    }
}