import java.util.*;
public class Main {
    public static int n, t;
    public static int[] upper, down;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();

        upper = new int[n];
        down = new int[n];

        for (int i = 0; i < n; i++){
            upper[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            down[i] = sc.nextInt();
        }

        for (int i =0; i < t; i++){
            upper = goUpper(upper);
            down = goUpper(down);
            
            int temp = upper[0];
            upper[0] = down[0];
            down[0] = temp;
        }
        String u = Arrays.toString(upper).replace(",", "").replace("[", "").replace("]", "").trim();
        String d = Arrays.toString(down).replace(",", "").replace("[", "").replace("]", "").trim();
        System.out.println(u);
        System.out.println(d);

    }

    public static int[] goUpper(int[] arr){
        int temp[] = new int[n];
        for (int i = 0; i < n -1; i++){
            temp[i+1] = arr[i];
        }
        temp[0] = arr[n-1];
        return temp;
    }
}