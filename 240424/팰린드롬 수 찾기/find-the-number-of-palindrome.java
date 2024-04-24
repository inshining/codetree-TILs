import java.util.*;

public class Main {
    public static int X,Y;
    public static int[] digits;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        int ans =0;
        for (int num = X; num <= Y; num++){
            int temp = num;
            digits = new int[7];
            int length = 0;
            while (temp > 0){
                digits[length] = temp % 10;
                length++;
                temp /= 10;
            }
            int start = 0;
            int end = length -1;
            boolean isPal = true;
            while (start <= end){
                if (digits[start] != digits[end]){
                    isPal = false;
                    break;
                }
                start++;
                end--;
            }
            if (isPal){
                ans++;
            }
        }
        System.out.println(ans);
    }
}