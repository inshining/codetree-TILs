import java.util.*;

class Point implements Comparable<Point>{
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

           points.add(new Point(s, 1));
           points.add(new Point(e, -1)); 
        }

        Collections.sort(points);
        int sumVal = 0;

        int ans =0;
        for (int i = 0; i < 2 * n; i++){
            int x = points.get(i).x;
            int v = points.get(i).v;

            if (sumVal >= 1){
                int preX = points.get(i-1).x;
                ans += x - preX;
            }

            sumVal += v;

        }
        System.out.println(ans);
    }
}