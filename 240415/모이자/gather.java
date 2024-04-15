import java.util.Scanner;
public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] a = new int[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i =0; i < n; i++)
            a[i] =  sc.nextInt();

        int ans = INT_MAX;
        for(int i = 0; i < n; i++){
            int sumDist = 0;
            for(int j = 0;  j < n; j++){
                sumDist += Math.abs(j-i) * a[j];
            }
            ans = Math.min(ans, sumDist);
        }

        System.out.println(ans);
    }
}