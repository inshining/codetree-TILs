import java.util.*;
public class Main {
    public static int K, N;
    public static int[] line;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        line = new int[N];
        go(0);
    }
    public static void print(){
        for (int i = 0; i < N; i++){
            System.out.print(line[i] + " ");
        }
        System.out.println();
    }

    public static void go(int idx){
        if (idx >= N){
            int num = 1;
            int k = line[0];
            boolean check = true;
            for (int i = 1; i < N; i++){
                if (k == line[i]){
                    num++;
                } else{
                    num = 1;
                    k = line[i];
                }
                if (num >= 3){
                    check = false;
                }
            }

            if (check){
                print();
            }
            return;
        }

        for (int i = 1; i <= K; i++){
            line[idx] = i;
            go(idx+1);
        }
    }
}