import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] redStones = new int[C];
        TreeSet<Integer> set = new TreeSet<>();
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
        Arrays.sort(blackStones);

        // int i = 0;
        // int j = 0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            Pair p = blackStones[i];
            // System.out.println(p.s + " " + p.e);

            int s = p.s;
            // System.out.println(set.ceiling(s));
            // System.out.println(set);

            if(set.ceiling(s) == null) continue;
            int k = set.ceiling(s);
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
            return this.e - other.e;
            // return this.s - other.s;
        }
    }
}