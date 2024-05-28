import java.util.*;
public class Main {
    public static int N,M, ans;
    public static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(sc.nextInt());
        }

        go(0, 0, 0);
        System.out.println(ans);
    }
    public static void go(int cnt, int idx, int v){
        if (cnt >= M){
            ans = Math.max(ans, v);
            return;
        }
        if (idx >= N){
            return;
        }

        int getV = list.get(idx);
        go(cnt + 1, idx+1, v ^ getV);
        go(cnt, idx+1, v);
    }
}