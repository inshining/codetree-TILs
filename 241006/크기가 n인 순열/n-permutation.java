import java.util.*;
public class Main {
    public static boolean[] visit;
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N+1];
        arr = new int[N];
        go(0);
        
    }
    public static void go(int idx){
        if(idx >= N){
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
            return;
        }
        for(int i = 1; i <= N; i++){
            if(visit[i]) continue;
            arr[idx] = i;
            visit[i] = true;
            go(idx+1);
            visit[i] = false;
        }
    }

}