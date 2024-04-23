import java.util.*;
public class Main {
    public static int x, y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();

        int ans = Integer.MIN_VALUE;
        for (int i = x; i <= y; i++){
            int total = 0;
            int num = i;
            for (int j = 0; j < 5; j++){
                total += num % 10;
                num = num / 10;
            }

            ans = Math.max(ans, total);
        }
        System.out.println(ans);
    }
}