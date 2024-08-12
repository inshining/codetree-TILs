import java.util.Scanner;
import java.util.HashMap;

public class Main {
    // 변수 선언
    public static int n;
    
    public static HashMap<Integer, Integer> minY = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        // 각 x마다 최소 y만 저장해줍니다.
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 아직 map에 해당 x가 없다면 y값을 그대로 넣어줍니다.
            if(!minY.containsKey(x))
                minY.put(x, y);
            // 그렇지 않다면, 최소 y를 넣어줍니다.
            else
                minY.put(x, Math.min(minY.get(x), y));
        }

        // 답을 저장합니다.
        long sumVal = 0;

        // map에 들어있는 값들을 순회합니다.
        for(Integer key : minY.keySet()) {
            // value에 해당하는 y값을 더해줍니다.
            sumVal += minY.get(key);
        }

        System.out.print(sumVal);
    }
}