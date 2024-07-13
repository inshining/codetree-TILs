import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int a;
        for (int i = 0; i < N; i++){
            String c = sc.next();
            if (c.equals("push")){
                a = sc.nextInt();
                s.push(a);
            } else if(c.equals("pop")){
                a = s.pop();
                System.out.println(a);
            } 
            else if(c.equals("size")){
                System.out.println(s.size());
            } 
            else if(c.equals("empty")){
                if (s.isEmpty()){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            } 
            else if(c.equals("top")){
                System.out.println(s.peek());
            } 
        }
    }
}