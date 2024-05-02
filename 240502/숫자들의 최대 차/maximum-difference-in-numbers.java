import java.util.*;
public class Main {
    public static int N, K;
    public static int [] arr = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr,0, N);
        
        int ans = 0;
        for (int i = 0; i < N; i++){
            int maxV = arr[i] + K;
            int num = 0;
            for (int j=i; j < N; j++){
                if (arr[j] <= maxV){
                    num++;
                } else{
                    break;
                }
            }
            // System.out.println(num);
            ans = Math.max(ans, num);
        }
        System.out.println(ans);
    }
}