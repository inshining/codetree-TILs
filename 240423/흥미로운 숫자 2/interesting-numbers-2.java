import java.util.*;
public class Main {
    public static int X, Y;
    public static int[] counter;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        int ans = 0;
        for (int i = X; i <= Y; i++){
            counter = new int[1000002];
            int num = i;
            for (int j = 0; j< 7; j++){
                int idx = num % 10;
                num = num / 10;

                counter[idx] += 1;
            }
            int a = i % 10;
            int b = (i / 10) % 10;
            if (counter[a] == (int)(Math.log10(i)) || counter[b] == (int)(Math.log10(i))){
                ans++;
            }
        }

        System.out.println(ans);
    }
}