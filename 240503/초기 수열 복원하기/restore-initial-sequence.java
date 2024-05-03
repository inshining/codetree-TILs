import java.util.*;
public class Main {
    public static int N;
    public static int[] arr = new int[1000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N-1; i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = new int[N];
        for (int i = 1; i < N+1; i++){
            boolean[] isCheck = new boolean[N+1];
            isCheck[i] = true;
            int val = i;
            boolean isSuccess = true;
            for (int j=0; j < N-1; j++){
                if (isCheck[arr[j] - val]){
                    isSuccess=false;
                    break;
                } else{
                    ans[j] = val;
                    isCheck[arr[j]-val] = true;
                    val = arr[j] - val;
                }
            }
            ans[N-1] = val;
            if (isSuccess){
                break;
            }
        }
        for (int i = 0; i <N; i++){
            System.out.print(ans[i] + " ");
        }
    }
}