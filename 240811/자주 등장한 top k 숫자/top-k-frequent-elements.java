import java.util.*;

class Pair{
    int key, value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k= sc.nextInt();
        
        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            int v= map.getOrDefault(a, 0);
            map.put(a, v+1);

        }

        List<Pair> l = new ArrayList<>();
        for (int key : map.keySet()){
            l.add(new Pair(key, map.get(key)));
        }
        l.sort((o1, o2) -> {
            if (o1.value - o2.value != 0){
                return o2.value - o1.value;
            }
            return o2.key - o1.key ;
        });
        for (int i = 0 ; i < k; i++){
            Pair p = l.get(i);
            System.out.print(p.key + " ");

        }
    }
}