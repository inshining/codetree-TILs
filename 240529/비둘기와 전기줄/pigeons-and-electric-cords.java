import java.util.*;
public class Main {
    public static int N;
    public static HashMap<Integer, Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();
        N = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < N; i++){
            int a = sc.nextInt();
            int b= sc.nextInt();

            if (map.containsKey(a)){
                if (map.get(a) != b){
                    ans++;
                    map.put(a, b);
                }
            }else{
                map.put(a,b);
            }
        }
        System.out.println(ans);
    }
}