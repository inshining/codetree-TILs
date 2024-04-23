import java.util.*;

public class Main {
    public static int N, C, G, H;
    public static int[][] arr;
    public static int cal_work(int Ta, int Tb, int t){
        if (t < Ta) return C;
        else if (Ta <= t && t <= Tb) return G;
        else return H;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        G = sc.nextInt();
        H = sc.nextInt();
        arr = new int[N][2];

        for (int i = 0; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < 1001; i++){
            int total = 0;
            for (int j =0; j < N; j++){
                total += cal_work(arr[j][0], arr[j][1], i);
            }
            ans = Math.max(ans, total);
        }

        System.out.println(ans);
    }
}