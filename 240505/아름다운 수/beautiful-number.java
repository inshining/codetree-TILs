import java.util.*;
public class Main {
    public static int N;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int ans = 0;
    public static boolean cal(){
        int num = 0;
        int pre =0;
        for (int i = 0; i < answer.size(); i++){
            int k = answer.get(i);
            if (k == 1){
                continue;
            }
            int j = 0;
            while (j < k){
                if (i + j >= N){
                    return false;
                }
                if (k != answer.get(i+j)){
                    return false;
                }
                j++;
            }
            i += k -1;
        }
        return true;
    }
    public static void go(int digit){
        if (digit == N){
            if (cal()){
                ans++;
            };
            return;
        }

        for (int i = 1; i <= 4; i++){
            answer.add(i);
            go(digit+1);
            answer.remove(answer.size() - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        go(0);
        System.out.println(ans);
    }
}