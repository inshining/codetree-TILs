import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = Integer.MAX_VALUE;
        int left = 1;
        int right = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            if(mooNum(mid) >= N){
                right = mid -1;
                ans = Math.min(ans, mid);
            } else left = mid + 1;
        }
        System.out.println(ans);


    }

    static int mooNum(int mid){
        int moo = mid / 3 + mid / 5 - mid / 15;
        return mid - moo;
    }
}