import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[101];
        int n = sc.nextInt();

        for (int i =0 ; i< n;i++){
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 2; i++){
            int s = sc.nextInt();
            int e= sc.nextInt();

            s--;
            e--;

            int[] temp = new int[101];

            int idx = 0;
            for (int j = 0; j < 101; j++){
                if (j < s || e < j)
                    temp[idx++] = arr[j];
            }

            for (int j = 0; j < 101; j++){
                arr[j] = temp[j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] > 0){
                cnt++;
            } else{
                break;
            }
            
            
        }

        System.out.println(cnt);

        for (int i = 0; i < n; i++){
            if (arr[i] == 0){
                break;
            }
            System.out.println(arr[i]);
        }
    }
}