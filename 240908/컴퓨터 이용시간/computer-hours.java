import java.util.*;

class Point implements Comparable<Point> {
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
        Scanner sc = new Scanner(System.in);

        ArrayList<Point> points = new ArrayList<>();

        TreeSet<Integer> t = new TreeSet<>();
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            t.add(i);
        }


        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            points.add(new Point(s, 1, i));
            points.add(new Point(e, -1, i));    
        }

        Collections.sort(points);

        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i< 2 * n; i++){
            int x = points.get(i).x;
            int v = points.get(i).v;
            int idx = points.get(i).idx;

            if (v == 1){
                int minV = t.first();
                t.remove(minV);

                hs.put(idx, minV);
            
            } else{
                int minV = hs.get(idx);
                t.add(minV);
            }
            
        }

        int[] arr = new int[n];

        for (int k : hs.keySet()){
            int v = hs.get(k);
            // System.out.println(k + " " + v);
            arr[k] = v;
            // System.out.print(v + " ");
        }

        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }


    }
}