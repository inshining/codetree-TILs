import java.util.*;
import java.util.Map.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> m = new TreeMap<>();
        int n = sc.nextInt();

        for (int i =0; i < n; i++){
            String s = sc.next();
            int v = m.getOrDefault(s, 0);
            m.put(s, v+1);
        }

        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();

        while (it.hasNext()){
            Entry<String, Integer> e = it.next();
            int t = e.getValue();

            System.out.println(e.getKey() + " " + t);
        }
    }
}