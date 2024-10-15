import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N];
        int right = 0;
        for(int i = 0; i< N; i++){
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        int left =1;

        int k = Integer.MIN_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            if(possible(mid, M)){
                k = Math.max(k, mid);
                left = mid + 1;
            }else right = mid -1;
        }
        System.out.println(k);
    }
    static boolean possible(int mid, int M){
        int num = 0;
        for(int i = 0; i < arr.length; i++){
            num += arr[i] / mid;
        }
        return num >= M;
    }
}