import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int ans = 0;
        for (int i = 0; i < a.length()-1; i++){
            for (int j = i+2; j < a.length()-1; j++){
                if (a.charAt(i) == '(' && a.charAt(i+1) == '(' && a.charAt(j) == ')' && a.charAt(j+1) == ')') ans++;
            }
        }
        System.out.println(ans);
    }
}