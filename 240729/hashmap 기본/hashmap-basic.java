import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i =0; i < n; i++){
            String s = sc.next();
            if (s.equals("add")){
                int a = sc.nextInt();
                int b = sc.nextInt();

                map.put(a, b);
            } else if(s.equals("find")){
                int a = sc.nextInt();
                int v = map.getOrDefault(a,0);
                // int v = map.get(a, 0);
                if (v == 0){
                    System.out.println("None");
                } else{
                    System.out.println(v);
                }
            } else if(s.equals("remove")){
                int a = sc.nextInt();
                map.remove(a);
            }
        }
    }
}