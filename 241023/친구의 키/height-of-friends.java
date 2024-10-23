import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] board = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            board[i] = new ArrayList<>();
        }

        int[] indegree = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            board[s].add(e);
            indegree[e]++;

        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int k = q.poll();
            sb.append(k);
            sb.append(" ");

            for(int i = 0; i < board[k].size(); i++){
                int next = board[k].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
        
    }
}