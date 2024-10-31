import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge>[] board = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            board[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[s].add(new Edge(e,w));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            
            if(dist[e.to] < e.w) continue;

            for(Edge next : board[e.to]){
                if(dist[next.to] > dist[e.to] + next.w){
                    dist[next.to] = dist[e.to] + next.w;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        for(int i = 2; i <= N; i++){
            int v = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
            System.out.println(v);
        }
    }

    static class Edge implements Comparable<Edge>{
        int to, w;
        public Edge(int to, int w){
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other){
            if(this.w == other.w) return this.to - other.to;
            return this.w - other.w;
        }
    }
}