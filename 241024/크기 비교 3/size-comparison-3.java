import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] indegree = new int[n+1];
        ArrayList<Integer>[] board = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            board[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[s].add(e);
            indegree[e]++;
        }
        StringBuilder sb = new StringBuilder();


        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) {
                sb.append(i);
                sb.append(' ');
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int node = pq.poll();

            for(int i = 0; i < board[node].size(); i++){
                int next = board[node].get(i);
                indegree[next]--;

                
                if(indegree[next] == 0){
                    sb.append(next);
                    sb.append(' ');
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}