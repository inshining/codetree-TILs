import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long ans = Long.MAX_VALUE;
        long left = 1;
        long right = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;
            if(mooNum(mid) >= N){
                right = mid -1;
                ans = Math.min(ans, mid);
            } else left = mid + 1;
        }
        System.out.println(ans);


    }

    static long mooNum(long mid){
        long moo = mid / 3 + mid / 5 - mid / 15;
        return mid - moo;
    }
}