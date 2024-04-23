import java.util.*;
public class Main {
    public static int X, Y;
    public static Map<Integer, Integer> counter;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        int ans = 0;
        for (int i = X; i <= Y; i++){
            counter = new HashMap<Integer, Integer>();
            int num = i;
            for (int j = 0; j< 7; j++){
                int idx = num % 10;
                num = num / 10;
                if (counter.containsKey(idx)){
                    counter.put(idx, counter.get(idx)+1);
                } else{
                    counter.put(idx, 1);
                }
                if (counter.size() > 2) break;
            }
            for (int v : counter.values()){
                if (v == (int)(Math.log10(i))) ans++;
            }
        }

        System.out.println(ans);
    }
}