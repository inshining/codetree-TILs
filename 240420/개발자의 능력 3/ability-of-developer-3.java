import java.util.*;
public class Main {
    public static int [] arr = new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i =0; i < 6; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++){
            for (int j=i+1; j < 6; j++){
                for (int k = j+1; k <6; k++){
                    ans = Math.min(ans, Math.abs((arr[i] + arr[j] + arr[k]) * 2  - sum));
                }
            }
        }
        System.out.println(ans);
    }
}