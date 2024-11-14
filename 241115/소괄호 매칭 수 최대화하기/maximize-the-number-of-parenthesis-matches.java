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

        // List<Pair> list = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(br.readLine());
            // ss[i] = br.readLine();
            // int left = 0;
            // int right = 0;
            // for(int j = 0; j < ss[i].length(); j++){
            //     char c = ss[i].charAt(j);
            //     if(c == '(') left++;
            //     else if(c==')') right++;
            // }
            // list.add(new Pair(i, left, right));
        }

        Collections.sort(list, (o1, o2) -> {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            sb1.append(o1).append(o2);
            sb2.append(o2).append(o1);
            int a = go(sb1.toString());
            int b = go(sb2.toString());

            return b - a;

        });
        
        StringBuilder T = new StringBuilder();

        for(String s : list){
            T.append(s);
        }
        // int left = 0;
        int ans = go(T.toString());
        System.out.println(ans);
        // System.out.println(T);

    }

    public static int go(String T){
        int ans = 0;
        int left = 0;

        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(c == '('){
                left++;
            } else{
                ans += left;
            }
        }
        return ans;
    }
}