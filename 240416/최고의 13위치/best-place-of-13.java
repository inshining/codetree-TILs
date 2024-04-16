import java.util.Scanner;

public class Main {
    public static int[][] arr = new int[21][21];
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n;i++)
            for (int j =0; j <n; j++)
                arr[i][j] = sc.nextInt();
        
        int ans = 0;
        for (int i=0; i <n; i++){
            for (int j=0; j < n-2; j++){
                ans = Math.max(ans, arr[i][j] + arr[i][j+1] + arr[i][j+2]);
            }
        }
        System.out.println(ans);
    }
}