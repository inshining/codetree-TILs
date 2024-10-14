import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Tuple> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            list.add(new Tuple(s,e,p));
        }
        Collections.sort(list);
        int[] dp = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            dp[i] = list.get(i).p;
            
            for(int j = 0; j < i; j++){
                if(list.get(i).s > list.get(j).e){
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).p);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, dp[i]);
        }
        // int ans = Collections.max(dp);

        System.out.println(ans);
    }

    static class Tuple implements Comparable<Tuple>{
        int s,e, p;
        public Tuple(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public int compareTo(Tuple t){
            if(this.s != t.s){
                return this.s - t.s;
            }
            if(this.e != t.e) return this.e - t.e;
            return this.p - t.p;
        }
    }
}