import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int ans = 0;
        String k;
        int n = a.length();
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == '0'){
                k  = a.substring(0, i) + '1' + a.substring(i+1);
            } else{
                k = a.substring(0,i) + '0' + a.substring(i+1);
            }
            int num = 0;
            for (int j = 0; j <  n; j++){
                if (k.charAt(j) == '1'){
                    num += (int) Math.pow(2, n- j-1);
                }
            }
            ans = Math.max(ans, num);
            
        }
        System.out.println(ans);
    }
}