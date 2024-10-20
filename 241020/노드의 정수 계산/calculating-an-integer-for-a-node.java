import java.util.*;

public class Main {
    static int MAX_N = 100001;
    static ArrayList<Integer>[] map;
    static int[] dp = new int[MAX_N];
    static int[] value = new int[MAX_N];
    static int[] parent = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            map[i] = new ArrayList<Integer>();
        }

        int[] leaf = new int[N+1];
        for(int i = 0; i < N - 1; i++){
            int t = sc.nextInt();
            int a = sc.nextInt();
            int p = sc.nextInt();

            if(t == 0) a = -a;
            value[i+2] = a;
            parent[i+2] = p;
            map[p].add(i+2);
            leaf[p]++;
        }
        // for(int i = 1; i <= N; i++){
        //     System.out.println(map[i]);
        // }
        dfs(1);

        System.out.println(dp[1]);
    }

    static void dfs(int x){
        dp[x] = value[x];
        for(int i = 0; i < map[x].size(); i++){
            int y = map[x].get(i);
            dfs(y);

            if(x == parent[y] && dp[y] > 0) dp[x] += dp[y];

        }
    }
}