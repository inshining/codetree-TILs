import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> m = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            String c = sc.next();

            if (c.equals("add")){
                int k = sc.nextInt();
                int v = sc.nextInt();

                m.put(k,v);
            } else if(c.equals("remove")){
                int k = sc.nextInt();
                m.remove(k);
            } else if(c.equals("find")){
                int k = sc.nextInt();
                if (m.containsKey(k)){
                    int v = m.get(k);

                    System.out.println(v);
                } else{
                    System.out.println("None");
               
                }
            }else if(c.equals("print_list")){
                if (m.size() <= 0){
                    System.out.println("None");
                    continue;
                }
                Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
                
                while (it.hasNext()){
                    Entry<Integer, Integer> e = it.next();
                    System.out.print(e.getValue() + " ");
                }
                System.out.println();
            }
        }
    }
}