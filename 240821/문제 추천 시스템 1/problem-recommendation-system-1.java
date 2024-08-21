import java.util.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        if (this.x != p.x)
            return this.x - p.x;
        else
            return this.y - p.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Pair> t = new TreeSet<>();

        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++){
            int p = sc.nextInt();
            int l = sc.nextInt();

            t.add(new Pair(l, p));
        }

        n = sc.nextInt();

        for (int i = 0; i <n; i++){
            String a = sc.next();
            if (a.equals("ad")){
                int P = sc.nextInt();
                int L = sc.nextInt();

                t.add(new Pair(L, P));
            } else if(a.equals("sv")){
                int P = sc.nextInt();
                int L = sc.nextInt();

                t.remove(new Pair(L, P));
            } else if(a.equals("rc")){
                int k = sc.nextInt();
                Pair p;
                if (k == 1 && t.last() != null){
                    p = t.last();
                    System.out.println(p.y);
                } else if(k == -1 && t.first() != null){
                    p = t.first();
                    System.out.println(p.y);

                }

                
            }


        }
    }
}