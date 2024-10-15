import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long K = sc.nextLong();

        long left = 1;
        long right = N * N;

        long ans = N * N;

        while(left <= right){
            long mid = (left + right) / 2;
            long order = getNum(mid, N);
            // System.out.println(left + " " + mid + " " + right + " " + order);

            if(order >= K){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }else left = mid + 1;
        }
        System.out.println(ans);
    }
    public static long getNum(long mid, long N){
        long num = 0;
        for(long i = 1; i <= N; i++){
            num += Math.min(N, (mid / i));
        }
        return num;
    }
}