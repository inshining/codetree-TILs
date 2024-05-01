import java.util.*;
public class Main {
    public static int N;
    public static char[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = sc.next().toCharArray();
        
        int ans = 0;

        for (int i = 0; i < N; i++){
            if (arr[i] == '0'){
                arr[i] = '1';

                int minDist = N;
                for (int j = 0; j < N; j++){
                    for (int k =j+1; k <N; k++){
                        if (arr[j] == '1' && arr[k] == '1'){
                            minDist = Math.min(minDist, k - j);
                        }
                    }
                }
                ans = Math.max(ans, minDist);
                arr[i] = '0';
            }
        }

        System.out.println(ans);
    }
}