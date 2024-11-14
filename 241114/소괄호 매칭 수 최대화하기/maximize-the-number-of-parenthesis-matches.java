import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int id, s, e;
        public Pair(int id, int s, int e){
            this.id = id;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair other){
            int a = this.s - this.e;
            int b= other.s - other.e;
            if(b == a){
                if(this.s == other.s) return this.e - other.e;
                return this.s - other.s;
            }
            return b - a;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] ss = new String[N];

        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            ss[i] = br.readLine();
            int left = 0;
            int right = 0;
            for(int j = 0; j < ss[i].length(); j++){
                char c = ss[i].charAt(j);
                if(c == '(') left++;
                else if(c==')') right++;
            }

            list.add(new Pair(i, left, right));
        }

        Collections.sort(list);
        StringBuilder T = new StringBuilder();
        for(int i = 0; i < N; i++){
            Pair p = list.get(i);
            T.append(ss[p.id]);
            // System.out.println(p.id + " " + p.s + " " + p.e);
        }

        int left = 0;
        int ans = 0;
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(c == '('){
                left++;
            } else{
                ans += left;
            }
        }
        System.out.println(ans);
        // System.out.println(T);

    }
}