import java.util.*;

public class Main {
    public static int[] A = new int[101];
    public static int[] B = new int[101];
    public static int[] C = new int[101];
    public static int N;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < 4; i++){
            int turn = 0;
            int[] cups = new int[4];
            cups[i] = 1;
            int temp;
            for (int j= 0; j < N; j++){
                temp = cups[A[j]];
                cups[A[j]] = cups[B[j]];
                cups[B[j]] = temp;
                if (cups[C[j]] == 1){
                    turn++;
                }
            }
            ans = Math.max(ans, turn);
        }
        System.out.println(ans);
    }
}