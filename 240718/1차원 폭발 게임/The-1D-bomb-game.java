import java.util.*;


public class Main {
    public static int n, m;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for (int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int num;
        for (int i =0 ; i < n; i++){

            num = bomb();

            if (num <= 0){
                break;
            }
        }

        int ans  = 0;
        for (int i =0; i < n; i++){
            if (arr[i] >0){
                ans++;
            } else{
                break;
            }
        }
        System.out.println(ans);
        for (int i =0; i < n; i++){
            if (arr[i] >0){
                System.out.println(arr[i]);
            } else{
                break;
            }
        }
    }

    public static int bomb(){
        boolean[] check = new boolean[n];
        int cnt = 0;
        int idx = 0;
        while (idx < n){
            cnt = 0;
            if (arr[idx] == 0){
                break;
            }
            for (int j = idx; j < n; j++){
                if (arr[idx] == arr[j]){
                    cnt++;
                } else{
                    if (cnt >= m){
                        for (int k =0; k < cnt; k++){
                            check[idx+k] = true;
                        }
                    }
                    cnt = 0;
                    idx = j-1;
                    break;
                }
            }
            if (cnt >= m){
                for (int j = 1; j <= cnt; j++){
                    check[n-j] = true;
                }
                idx += cnt -1;
            }
            idx++;
        }     

        int ans = 0;
        for (int i =0; i < n; i++){
            if (check[i]){
                ans++;
                arr[i] = 0;
            }
        }

        int temp[] = new int[n];
        idx = 0;
        for (int i =0; i < n; i++){
            if (arr[i] > 0){
                temp[idx] = arr[i];
                idx++;
            }
        }
        
        arr = temp;

        return ans;
    }
}