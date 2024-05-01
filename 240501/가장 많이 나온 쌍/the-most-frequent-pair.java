import java.util.*;
public class Main {
    public static int N, M;
    public static int[] A = new int[101];
    public static int[] B = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int a,b;
        for (int i = 0; i < M; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            if ( a <= b){
                A[i] = a;
                B[i] = b;
            } else{
                A[i] = b;
                B[i] = a;
            }
        }

        int ans = 0;
        for (int i = 1; i < N; i++){
            for (int j=i; j <N; j++){
                int temp = 0;

                for (int k = 0; k < M; k++){
                    if (A[k] == i && B[k] == j){
                        temp++;
                    }
                }

                ans = Math.max(ans, temp);
            }
        }
        System.out.println(ans);

    }
}