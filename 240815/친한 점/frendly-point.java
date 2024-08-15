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

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Pair> t = new TreeSet<>();

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            t.add(new Pair(x, y));
            
        }

        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();  
            Pair p = new Pair(x,y);
            Pair last = t.last();
            if (p.compareTo(last) > 0){
                System.out.println(-1 + " " + -1);
            }else{
                Pair find = t.ceiling(p);
                System.out.println(find.x + " " + find.y);
            }
        }

    }
}