import java.util.*;

class Point implements Comparable<Point>{
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p){
        if (this.x - p.x != 0){
            return this.x -p.x;
        }
        return p.v - this.v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();


        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr.add(new Point(s, 1));
            arr.add(new Point(e, -1));

        }

        Collections.sort(arr);

        int ans = 0;
        int sumVal = 0;

        for (int i = 0; i < 2 * n; i++){
            int x = arr.get(i).x;
            int v = arr.get(i).v;

            sumVal += v;
            ans = Math.max(ans, sumVal);
        }

        System.out.println(ans);

    }
}