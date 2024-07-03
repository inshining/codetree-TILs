import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Character> l = new LinkedList<>();
        String s = sc.next();
        for (int i = 0; i < N; i++){
            l.add(s.charAt(i));
        }
        ListIterator<Character> it = l.listIterator(l.size());
        
        for (int i = 0; i < M; i++){
            String c = sc.next();
            if (c.equals("L")){
                if (it.hasPrevious()){
                    it.previous();
                } 
            } else if (c.equals("R")){
                if (it.hasNext()){
                    it.next();
                }
            } else if (c.equals("D")){
                if (it.hasNext()){
                    it.next();
                    it.remove();
                }
            } else{
                String input = sc.next();
                it.add(input.charAt(0));
            }
            // System.out.println(it.nextIndex());
        }
        it = l.listIterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
    }
}