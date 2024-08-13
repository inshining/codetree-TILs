import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> h = new HashSet<>();

        for (int i = 0; i < n; i++){
            String s = sc.next();
            int v = sc.nextInt();
            if (s.equals("add")){
                h.add(v);
            } else if(s.equals("remove")){
                h.remove(v);
            } else if(s.equals("find")){
                System.out.println(h.contains(v));
            }
        }
    }
}