import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            String s = sc.next();

            if (s.equals("add")){
                int v = sc.nextInt();
                t.add(v);
            } else if(s.equals("remove")){
                int v = sc.nextInt();
                t.remove(v);
            }else if(s.equals("find")){
                int v = sc.nextInt();
                System.out.println(t.contains(v));
            }else if(s.equals("lower_bound")){
                int v = sc.nextInt();
                if (t.ceiling(v) == null){
                    System.out.println("None");

                } else{
                    System.out.println(t.ceiling(v));

                }
            }else if(s.equals("upper_bound")){
                int v = sc.nextInt();
                if (t.higher(v) == null){
                    System.out.println("None");

                } else{
                    System.out.println(t.higher(v));

                }
            }else if(s.equals("largest")){

                if (t.size() <= 0){
                    System.out.println("None");

                } else{
                    System.out.println(t.last());

                }
            }else if(s.equals("smallest")){
                if (t.size() <= 0){
                    System.out.println("None");

                } else{
                    System.out.println(t.first());

                }
            }
            // System.out.println(t);
        }
    }
}