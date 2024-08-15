import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> t = new TreeSet<>();

        int testcase = sc.nextInt();

        for (int i = 0; i < testcase; i++){
            int n = sc.nextInt();

            for (int j =0; j < n; j++){
                String s= sc.next();
                int v = sc.nextInt();
                if (s.equals("I")){
                    t.add(v);
                } else if(v == 1){
                    if (t.size() > 0){
                        t.remove(t.last());
                    }
                }else if(v == -1){
                    if (t.size() > 0){
                        t.remove(t.first());
                    }
                }
            }

            if (t.size() > 0){
                System.out.println(t.last() + " " + t.first());
            } else{
                System.out.println("EMPTY");
            }
        }

    }
}