import java.util.*;

class Point implements Comparable<Point>{
    int x, v, idx;
    public Point(int x, int v, int idx){
        this.x = x;
        this.v = v;
        this.idx = idx;

    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        HashSet<Integer> hs = new HashSet<>();

        int ans = 0;

        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            points.add(new Point(s, 1, i));
            points.add(new Point(e, -1, i));
            
        }

        Collections.sort(points);

        for (int i = 0; i < 2 * n; i++){
            int x = points.get(i).x;
            int v = points.get(i).v;
            int idx = points.get(i).idx;

            if (v == 1){
                if (hs.size() == 0)
                    ans++;
                hs.add(idx);
            } else{
                hs.remove(idx);
            }
        }
        System.out.println(ans);
    }
}