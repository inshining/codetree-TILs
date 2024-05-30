import java.util.*;
public class Main {
    public static int N;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= N; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[N]);
    }
}