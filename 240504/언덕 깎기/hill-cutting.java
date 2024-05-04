import java.util.*;
public class Main {
    public static int N;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 100-17; i++){
            int total = 0;
            for (int j = 0; j < N; j++){
                int k;
                if (arr[j] < i ){
                    k = Math.abs(arr[j] - i);
                    total += k * k;
                } else if(i + 17 < arr[j]){
                    k = Math.abs(arr[j] - (i+17));
                    total += k * k;
                }
            }
            ans = Math.min(ans, total);
        }
        System.out.println(ans);

    }
}