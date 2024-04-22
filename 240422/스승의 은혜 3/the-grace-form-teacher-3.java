import java.util.*;
public class Main {
    public static int N, B;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < N;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int ans = 0;
        for (int i =0; i < N; i++){
            int total = 0;
            int[] sums = new int[N];
            for (int j = 0; j < N; j++){
                if (j ==i){
                    sums[j] = arr[j][0] / 2 + arr[i][1];
                } else{
                    sums[j]= arr[j][0] + arr[j][1];
                }
            }
            Arrays.sort(sums);
            
            for (int k = 0; k <N; k++){
                total += sums[k];
                if (total <= B){
                    ans = Math.max(ans, k+1);
                }
            }
        }
        System.out.println(ans);
    }
}