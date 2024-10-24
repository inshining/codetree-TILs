import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<Character, ArrayList<Character>> board = new TreeMap<Character, ArrayList<Character>>();
        TreeMap<Character, ArrayList<Character>> ans = new TreeMap<Character, ArrayList<Character>>();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++){
            char c = st.nextToken().charAt(0);
            board.put(c, new ArrayList<>());
            map.put(c, 0);
            ans.put(c, new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            char y = st.nextToken().charAt(0);
            board.get(y).add(x);
            int v = map.get(x);
            map.put(x, v+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char c : map.keySet()){
            if(map.get(c) == 0){
                pq.offer(c);
                sb.append(c);
                sb.append(' ');
                num++;
            } 
        }
        sb.append('\n');

        while(!pq.isEmpty()){
            char c = pq.poll();
            
            for(char next : board.get(c)){
                int v = map.get(next);
                map.put(next, v-1);
                if(map.get(next) == 0){
                    ans.get(c).add(next);
                    pq.offer(next);
                }
            }
        }

        for(char c : ans.keySet()){
            sb.append(c);
            sb.append(' ');
            sb.append(ans.get(c).size());
            sb.append(' ');
            for(int i = 0; i < ans.get(c).size(); i++){
                char child = ans.get(c).get(i);
                sb.append(child);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(num);
        System.out.println(sb.toString());
    }
}