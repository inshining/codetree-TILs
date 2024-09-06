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
        int k = sc.nextInt();

        ArrayList<Point> points = new ArrayList<>();

        int s = 0;

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            int e = 0;
            if (c == 'R')
                e = s + x;
            else if(c=='L')
                e = s - x;
            
            if (s < e){
                points.add(new Point(s, 1));
                points.add(new Point(e, -1));
            } else{
                points.add(new Point(s, -1));
                points.add(new Point(e, 1));                
            }

            // System.out.println(s + " " + e);
            s = e;
        }

        Collections.sort(points);

        int sumVal = 0;
        int ans = 0;

        for (int i = 0; i < 2 * n; i++){
            int x = points.get(i).x;
            int v = points.get(i).v;

            if (v == 1){
                sumVal++;
            } else{
                sumVal--;
            }

            // System.out.println(x + " " + sumVal);

            if (v == 1 && sumVal >= k && i + 1 < 2 * n){
                // System.out.println(x + " " + (points.get(i+1).x - x));
                ans += points.get(i+1).x - x;
                
            }
        }
        System.out.println(ans);
    }
}