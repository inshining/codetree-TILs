import java.util.*;
public class Main {
    public static int N;
    public static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new long[1001];
        
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i <= N; i++){
            arr[i] = (arr[i-2] * 3 + arr[i-1] * 2) % 1000000007;
            for (int j = i -3; j >= 0; j--){
                arr[i] = (arr[i] + arr[j] * 2) % 1000000007;
            }
        }
        System.out.println(arr[N]);
    }
}