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
        t.add((int) 1e9 + 1);

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

            int a2 = t.ceiling(a);
            int b2 = t.higher(b);
            // if (a2 == null){
            //     a2 = Integer.MIN_VALUE;
            // }
            // if (b2 == null){
            //     b2 = Integer.MIN_VALUE;
            // }
            int newA = hm.get(a2);
            int newB = hm.get(b2);

            System.out.println(newB - newA);
        }

    }
}