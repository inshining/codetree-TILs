import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n / 5;
        int ans = 0;
        for(int i =k ; i >= 0; i--){
            int remain = n - (5 * i);
            ans = i + (remain / 2);
            if(remain % 2 == 0){
                break;
            }
        }
        System.out.println(ans);
    }
}