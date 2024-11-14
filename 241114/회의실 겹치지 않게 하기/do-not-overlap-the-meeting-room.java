import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int s, e;
        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair other){
            return this.e - other.e;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Pair> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Pair(s,e));
        }

        Collections.sort(list);

        int ans= 0;
        int cur = -1;
        for(int i = 0; i < N; i++){
            Pair p = list.get(i);
            if(cur <= p.s){
                ans++;
                cur = p.e;
            }
        }
        int result = N - ans;
        System.out.println(result);
    }
}