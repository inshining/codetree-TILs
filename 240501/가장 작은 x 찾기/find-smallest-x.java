import java.util.*;
public class Main {
    public static int N;
    public static int[] A = new int[11];
    public static int[] B = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        int ans = 0;
        for (int x = 1; x < 5001; x++){
            boolean isSucces = true;
            int num = x;
            for (int i = 0; i < N; i++){
                num *= 2;
                if (num < A[i] || B[i] < num){
                    isSucces = false;
                    break;
                }
            }
            if (isSucces){
                ans = x;
                break;
            }
        }
        System.out.println(ans);
    }
}