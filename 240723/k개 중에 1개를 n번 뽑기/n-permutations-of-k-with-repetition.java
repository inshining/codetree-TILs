import java.util.*;
public class Main {
    public static int k, n;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        go(0);
        
    }

    public static void go(int idx){
        if (n == idx){
            System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]",""));
            return;
        }

        for (int i = 1; i <= k; i++){
            arr[idx] = i;
            go(idx+1);
        }
    }
}