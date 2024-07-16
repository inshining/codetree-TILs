import java.util.*;

public class Main {
    public static int n, t;
    public static int[] arr1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        arr1 = new int[3 * n];

        for (int i = 0; i < 3 * n;i++){
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++){
            arr1 = rotate(arr1);

        }
        int[] a1 = Arrays.copyOfRange(arr1, 0, n);
        int[] a2 = Arrays.copyOfRange(arr1, n, 2 *n);
        int[] a3 = Arrays.copyOfRange(arr1, 2 * n, 3 * n);

        System.out.println(Arrays.toString(a1).replace(",", "").replace("[","").replace("]", "").trim());
        System.out.println(Arrays.toString(a2).replace(",", "").replace("[","").replace("]", "").trim());
        System.out.println(Arrays.toString(a3).replace(",", "").replace("[","").replace("]", "").trim());

        
    }
    public static int[] rotate(int[] arr){
        int temp[] = new int[3 * n];

        for (int i = 0; i < 3 *n - 1; i++){
            temp[i+1] = arr[i];
        }
        temp[0] = arr[3 * n - 1];
        return temp;
    }
}