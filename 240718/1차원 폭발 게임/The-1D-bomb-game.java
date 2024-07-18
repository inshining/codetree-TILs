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
        boolean check;
        for (int i =0 ; i < n; i++){

            check = bomb();

            if (!check){
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

    public static boolean bomb(){
        boolean check = false;
        int idx = 0;
        while (idx < n){
            int cnt = 0;
            if (arr[idx] == 0){
                break;
            }
            int endIdx = idx;
            while (endIdx < n){
                if (arr[idx] != arr[endIdx]){
                    break;
                } 
                endIdx++;
            }
            if (endIdx - idx >= m){
                for (int i = idx; i < endIdx; i++){
                    arr[i] = 0;
                }
                check = true;
            }
            idx = endIdx;

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

        return check;
    }
}