import java.util.*;
public class Main {
    public static int N;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[1001];
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= N; i++){
            arr[i] = arr[i-2] + arr[i-3]; 
        }
        System.out.println(arr[N]);
    }
}