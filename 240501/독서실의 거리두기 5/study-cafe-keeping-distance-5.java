import java.util.*;
public class Main {
    public static int N;
    public static int[] arr = new int[21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String line = sc.next();
        for (int i = 0; i < N; i++){
            char k =  line.charAt(i);
            if (k == '1'){
                arr[i] = 1;
            } else{
                arr[i]= 0;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i =0; i< N; i++){
            if (arr[i] == 1){
                continue;
            }
            int left = i;
            int dis = Integer.MAX_VALUE;
            while (left >= 0){
                if (arr[left]==1){
                    break;
                }
                left--;
            }
            if (left >= 0){
                dis = i - left;
            }

            int right = i;
            while (right < N){
                if (arr[right]== 1){
                    break;
                }
                right++;
            }
            if (right < N){
                dis = Math.min(dis, right-i);
            }
            ans = Math.max(ans, dis);

            // System.out.println(ans + " " + i + " " + left + " " + right);
        }
        System.out.println(ans);
    }
}