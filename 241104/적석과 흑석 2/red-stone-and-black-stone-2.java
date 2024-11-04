import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        int[] redStones = new int[C];
        Pair[] blackStones = new Pair[N];
        
        // st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            // redStones[i] = Integer.parseInt(br.readLine());
            set.add(Integer.parseInt(br.readLine()));
        }

        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            blackStones[i] = new Pair(s, e);
        }

        // Arrays.sort(redStones);
        System.out.println(set);
        Arrays.sort(blackStones);

        // int i = 0;
        // int j = 0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            Pair p = blackStones[i];
            int s = p.s;
            
            if(set.floor(s) == null) continue;
            int k = set.floor(s);
            if(k <= p.e){
                ans++;
                set.remove(k);
            }
        }
        // while(i < C && j < N){
        //     int v = redStones[i];
        //     Pair p = blackStones[j];

        //     if(p.s <= v && v <= p.e) {
        //         ans++;
        //         i++;
        //         j++;
        //     }else if(v < p.s){
        //         i++;
        //     }else if(p.e < v){
        //         j++;
        //     }
        // }
        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair>{
        int s, e;
        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair other){
            if(this.s == other.s) return this.e - other.e;
            return this.s - other.s;
        }
    }
}