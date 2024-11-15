import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i = 1; i < n; i++){
            if(arr[i-1] == 0){
                ans++;
                arr[i-1] = 1;
                arr[i] = arr[i] == 0 ? 1 : 0;
                if(i + 1 < n) arr[i+1] = arr[i+1] == 0 ? 1 : 0;
            }
        }

        boolean isCheck = true;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0) isCheck = false;
        }

        if(!isCheck) ans = -1;
        System.out.println(ans);
    }
}