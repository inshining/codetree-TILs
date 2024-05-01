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
                arr[i] = 1;
            } else{
                arr[i] = 0;
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++){
            if (arr[i] == 0){
                arr[i] = 1;
                int dis = Integer.MAX_VALUE;

                int start = 0;
                for (int j = 0; j < N; j++){
                    if (arr[j] == 1){
                        start = j;
                        break;
                    }
                }


                for (int j = start+1; j < N; j++){
                    if (arr[j] == 1){
                        dis = Math.min(dis, j-start);
                        start = j;
                    }
                }

                dis = Math.min(dis, N-start);

                ans = Math.max(ans, dis);
                arr[i] = 0;
            }
        }

        System.out.println(ans);
    }
}