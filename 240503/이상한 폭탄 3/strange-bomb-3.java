import java.util.*;
public class Main {
    public static int N, K;
    public static int[] bombs = new int[100];
    public static boolean[] isCheck = new boolean[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int maxBomb = 1;
        int ans = 0;

        for (int i =0; i < N; i++){
            bombs[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++){
            if (isCheck[i]){
                continue;
            }
            int num = 1;
            int idx = i+1;
            isCheck[i] = true;
            int cnt = 0;
            while (cnt < K && idx < N){
                // System.out.println(idx);
                if (bombs[idx]== bombs[i]){
                    cnt = 0;
                    isCheck[idx] = true;
                    num++;
                }
                idx++;
                cnt++;
            }
            // System.out.println();

            // System.out.println(num + " " + bombs[i]);
            if (num == 1){
                continue;
            }
            if (maxBomb < num){
                maxBomb = num;
                ans = bombs[i];
            } else if (maxBomb == num && ans < bombs[i]){
                ans = bombs[i];
            }
        }
        System.out.println(ans);
    }
}