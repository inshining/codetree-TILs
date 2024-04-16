import java.util.Scanner;

public class Main {
    public static int [] arr = new int[101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j= i+1; j < n; j++){
                for (int k=j+1; k <n; k++){
                    if (arr[i] <= arr[j] && arr[j] <= arr[k]){
                        ans++;
                    }
                }
            }
        System.out.println(ans);
    }
}