import java.util.*;
import java.io.*;

public class Main {
    public static String s;
    public static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        boolean result = true;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push('(');
            } else if(s.charAt(i) == ')'){
                if (stack.isEmpty()){
                    result = false;
                    break;
                } 
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            result = false;
        }
        if (result){
            System.out.println("Yes");
        }else{
            System.out.println(("No"));
        }
    }
}