import java.util.*;

public class Main {
    public static int N, K;
    public static int[] arr= new int[102];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int num, pos;

        for (int i = 0; i < N; i++){
            num = sc.nextInt();
            pos = sc.nextInt();
            arr[pos] += num;
        }

        int ans = 0;
        for (int c = 0; c <= 100 - (2*K + 1); c++){
            num = 0;
            for (int j = 0; j < 2* K +1; j++){
                
                num += arr[c+j];
            }
            ans = Math.max(ans, num);
        }
        System.out.println(ans);


    }
}