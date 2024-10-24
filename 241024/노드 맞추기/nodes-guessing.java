import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<String, ArrayList<String>> board = new TreeMap<String, ArrayList<String>>();
        TreeMap<String, ArrayList<String>> ans = new TreeMap<String, ArrayList<String>>();

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++){
            String c = st.nextToken();
            board.put(c, new ArrayList<>());
            map.put(c, 0);
            ans.put(c, new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            board.get(y).add(x);
            int v = map.get(x);
            map.put(x, v+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(String c : map.keySet()){
            if(map.get(c) == 0){
                pq.offer(c);
                sb.append(c);
                sb.append(' ');
                num++;
            } 
        }
        sb.append('\n');

        while(!pq.isEmpty()){
            String c = pq.poll();
            
            for(String next : board.get(c)){
                int v = map.get(next);
                map.put(next, v-1);
                if(map.get(next) == 0){
                    ans.get(c).add(next);
                    pq.offer(next);
                }
            }
        }

        for(String c : ans.keySet()){
            sb.append(c);
            sb.append(' ');
            sb.append(ans.get(c).size());
            sb.append(' ');
            Collections.sort(ans.get(c));
            for(int i = 0; i < ans.get(c).size(); i++){
                String child = ans.get(c).get(i);
                sb.append(child);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(num);
        System.out.println(sb.toString());
    }
}