import java.util.*;
public class Main {
    public static int N, B;
    public static int[] arr = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, 0, N);
        int ans = 0;
        for (int i = 0; i < N; i++){
            int total = 0;
            for(int j =0; j <N; j++){
                if (i==j){
                    total += (arr[j] / 2);
                } else{
                    total += arr[j];
                }
                if (total <= B){
                    ans = Math.max(ans, j+1);
                }
            }
        }
        System.out.println(ans);
    }
}