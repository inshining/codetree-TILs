import java.util.*;

public class Main {
    public static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int ans = 30;
        for (int i = 0; i < s.length(); i++){
            ans = Math.min(ans, compression(s, i).length());

        }
        System.out.println(ans);
        
    }

    public static String compression(String s, int idx){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(idx);
        int counter = 1;
        for (int i = 1; i < s.length(); i++){
            idx++;
            idx = idx % s.length();
            if (s.charAt(idx) == c){
                counter++;
            } else{
                sb.append(c).append(counter);
                counter = 1;
            }
            c = s.charAt(idx);
        }
        sb.append(c).append(counter);
        return sb.toString();
    }
}