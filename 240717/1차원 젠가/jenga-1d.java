import java.util.*;

public class Main {
    public static int n, s1, e1, s2, e2;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        s1 = sc.nextInt();
        e1 = sc.nextInt();

        s2 = sc.nextInt();
        e2 = sc.nextInt();

        s1 -= 1;
        e1 -= 1;
        s2 -= 1;
        e2 -= 1;

        arr = go(arr, s1, e1);
        arr = go(arr, s2, e2);

        int cnt = 0;
        for (int i =0 ; i < n; i++){
            if (arr[i] > 0){
                cnt++;
            }
        }

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] go(int[] arr, int s, int e){
        int temp[] = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (i < s || e < i){
                temp[idx] = arr[i];
                idx++;
            }
        }
        return temp;
    }
}