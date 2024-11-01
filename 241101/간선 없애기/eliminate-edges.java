import java.util.*;
import java.io.*;

public class Main {
    static int[] history;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][N+1];
        
        for(int i = 0; i <= N; i++){
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        history = new int[N+1];
        int[][] edges = new int[M][3];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[s][e] = w;
            board[e][s] = w;
            edges[i] = new int[]{s,e,w};
        }


        int minDist = go(board, N);
        int idx = N;
        ArrayList<Integer> h = new ArrayList<>();
        h.add(idx);
        while(idx != 1){
            idx = history[idx];
            h.add(idx);
        }

        // System.out.println(h);
        int ans = 0;
        for(int i = h.size() - 1; i >= 1; i--){
            int s = h.get(i);
            int e = h.get(i-1);
            int t = board[s][e];
            
            board[s][e] = Integer.MAX_VALUE;
            board[e][s] = Integer.MAX_VALUE;
            int minD = go(board, N);
            if(minDist != minD) ans++;
            board[s][e] = t;
            board[e][s] = t;

        }
        System.out.println(ans);
    }

    static List<Integer> find(int N, int[] history){
        List<Integer> list = new ArrayList<>();

        int cur = N;
        while(cur != 1){

            list.add(cur);
            cur = history[cur];
        }
        list.add(cur);
        Collections.reverse(list);
        return list;
    }

    static int go(int[][] board, int N){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        dist[1] = 0;
        pq.offer(new int[]{0, 1});
        while(!pq.isEmpty()){
            int[] l = pq.poll();
            int w = l[0];
            int edge = l[1];

            if(dist[edge] < w) continue;

            for(int i = 1; i <= N; i++){
                if(board[edge][i] == Integer.MAX_VALUE) continue;
                int nextV = board[edge][i];
                if(dist[edge] + nextV < dist[i]){
                    dist[i] = dist[edge] + nextV;
                    history[i] = edge;
                    pq.offer(new int[]{dist[i], i});
                }
            }
        }
        return dist[N];
    }
}