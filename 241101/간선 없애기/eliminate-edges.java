import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][N+1];
        
        for(int i = 0; i <= N; i++){
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[s][e] = w;
        }

        int[] history = new int[N+1];
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
        int minDist = dist[N];
        List<Integer> route = find(N, history);
        Set<Integer> can = new HashSet<>();
        for(int i = 0; i < route.size() - 1; i++){
            int s = route.get(i);
            int e = route.get(i+1);
            int temp = board[s][e];
            board[s][e] = Integer.MAX_VALUE;
            int minD = go(board, N);
            can.add(minD);
            board[s][e] = temp;

        }
        int ans = can.contains(minDist) ? can.size() - 1 : can.size();
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
                    pq.offer(new int[]{dist[i], i});
                }
            }
        }
        return dist[N];
    }
}