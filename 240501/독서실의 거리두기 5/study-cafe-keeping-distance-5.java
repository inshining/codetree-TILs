import java.util.*;
public class Main {
    public static int N;
    public static int[] arr = new int[21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String line = sc.next();
        int p = 0;
        for (int i = 0; i < N; i++){
            char k =  line.charAt(i);
            if (k == '1'){
                arr[p] = i;
                p++;
            } 
        }

        int ans = Integer.MAX_VALUE;

        if (p==1){
            ans = Math.max(N-arr[0], arr[0]);
        } else{
            for (int i = 1; i < p; i++){
                ans = Math.min(ans, arr[i] - arr[i-1]);
            }
            int total = Integer.MIN_VALUE;
            for (int i =0; i< N; i++){
                if (line.charAt(i) == '0'){
                    int dis = Integer.MAX_VALUE;
                    for (int j = 0; j < p; j++){
                        dis = Math.min(dis, Math.abs(arr[j] - i));
                    }
                    // System.out.println(dis);
                    total = Math.max(total, dis);
                }
            }
            ans = Math.min(total, ans);
        }

        System.out.println(ans);
    }
}