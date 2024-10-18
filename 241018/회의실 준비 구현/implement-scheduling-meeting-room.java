import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int s = sc.nextInt();
            int e= sc.nextInt();
            list.add(new Pair(s,e));
        }
        Collections.sort(list);

        int num = 1;
        int e = list.get(0).e;
        for(int i = 1; i < N; i++){
            int s = list.get(i).s;
            if( e < s){
                e = s;
                num++;
            }
        }
        System.out.println(num);
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
        }
    }
}