import java.util.*;
import java.io.*;

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

        int num = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                q.offer(i);
                num++;
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i = 0; i < board[node].size(); i++){
                int next = board[node].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                    num++;
                }
            }
        }
        String ans = num == N ? "Consistent" :"Inconsistent";
        System.out.println(ans);
    }
}