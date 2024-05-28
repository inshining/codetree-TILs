import java.util.*;
class Pair{
    public int y,x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Main {
    public static int N, M; 
    public static double ans;
    public static int[][] arr;
    public static ArrayList<Pair> A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][2];
        A = new ArrayList<>();
        B = new ArrayList<>();
        for (int i =0; i<N; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            A.add(new Pair(y,x));
        }
        ans = 200000;
        go(0,0);
        System.out.println((int)ans);
    }

    public static void go(int idx, int sel){
        if (sel == 2){
            double v= Math.pow(B.get(0).y - B.get(1).y, 2) + Math.pow(B.get(0).x - B.get(1).x, 2);
            ans = Math.min(v, ans);
            return;
        }
        if (idx >= N){
            return;
        }
        B.add(A.get(idx));
        go(idx+1, sel+1);
        B.remove(B.size() - 1);
        go(idx+1, sel);
    }
}