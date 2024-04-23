import java.util.*;
public class Main {
    public static int X, Y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        int ans = 0;
        for (int i = X; i <= Y; i++){
            int[] counter = new int[10];
            int num = i;
            int digits = 0;
            while (num> 0){
                counter[num % 10]++;
                num = num / 10;
                digits++;
            }

            for (int j = 0; j <10; j++){
                if (counter[j] == digits -1){
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}