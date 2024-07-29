import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> strToInt = new HashMap<>();
        HashMap<Integer, String> intToStr = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++){
            String k = sc.next();
            strToInt.put(k, i+1);
            intToStr.put(i+1, k);
        }

        for (int i = 0; i < m; i++){
            String k = sc.next();
            if (k.matches("\\d+")){
                int v = Integer.parseInt(k);
                System.out.println(intToStr.get(v));
            } else{
                System.out.println(strToInt.get(k));

            }
        }
    }
}