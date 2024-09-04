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

            Integer a2 = Integer.MIN_VALUE;
            Integer b2 = Integer.MIN_VALUE;
            a2 = t.floor(a);
            b2 = t.floor(b);

            if (a2 != null){
                a2 = t.floor(a);
            } else{
                a2 = Integer.MIN_VALUE;
            }
            if (b2 != null){
                b2 = t.floor(b);
            } else{
                b2 = Integer.MIN_VALUE;
            }

            int f = 0;
            int c = 0;
            if (a2 != Integer.MIN_VALUE){
                f = hm.get(a2);
            }

            if (b2 != Integer.MIN_VALUE){
                c = hm.get(b2);
            }

            int ans = c - f >= 0 ? c -f : 0;
            if (a == a2){
                ans++;
            }

            System.out.println(ans);
        }

    }
}