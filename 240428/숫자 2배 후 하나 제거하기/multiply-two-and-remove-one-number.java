import java.util.*;
public class Main {
    public static int[] arr = new int[101];
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++){
            arr[i] *= 2;
            for (int j = 0; j <N; j++){
                int idx = 0;
                int[] temp = new int[N-1];
                for (int k = 0; k < N; k++){
                    if (j == k){
                        continue;
                    }
                    temp[idx++] = arr[k]; 
                }
                int diff = 0;
                for (int k = 0; k < N-2; k++){
                    diff += Math.abs(temp[k+1] - temp[k]);
                }
                ans = Math.min(ans, diff);
            }
            arr[i] /= 2;
        }

        System.out.println(ans);
    }
}