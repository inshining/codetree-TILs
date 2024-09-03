import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> t = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken()); 
        int q = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i< n; i++){
            int k =  Integer.parseInt(st.nextToken()); 
            t.add(k);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 1;
        for (int k : t){
            hm.put(k, idx);
            idx++;
        }



        for (int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 

            int a2 = Integer.MIN_VALUE;
            int b2 = Integer.MIN_VALUE;

            if (t.floor(a) != null){
                a2 = t.floor(a);
            }
            if (t.floor(b) != null){
                b2 = t.floor(b);
            }

            int f = 0;
            int c = 0;
            if (a2 != Integer.MIN_VALUE){
                f = hm.get(a2);
            }

            if (b2 != Integer.MIN_VALUE){
                c = hm.get(b2);
            }

            // System.out.println(a2 + " " + b2 + " " + f + " " + c);

            int ans = c - f >= 0 ? c -f : 0;
            if (a == a2){
                ans++;
            }

            System.out.println(ans);
        }
    }
}