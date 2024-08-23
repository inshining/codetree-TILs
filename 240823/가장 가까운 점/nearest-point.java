import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void add(){
        this.x += 2;
        this.y += 2;
    }

    @Override
    public int compareTo(Pair p){
        int d = Math.abs(this.x) + Math.abs(this.y);
        int pd = Math.abs(p.x) + Math.abs(p.y);

        if (d != pd){
            return d - pd;
        } else if(this.x != p.x){
            return this.x - p.x;
        } 
        return this.y - p.y;
    }
} 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            pq.add(new Pair(x,y));
        }

        for (int i = 0; i < m; i++){
            Pair p = pq.poll();
            p.add();
            pq.add(p);
        }

        Pair p = pq.poll();
        System.out.println(p.x + " " + p.y);

    }
}