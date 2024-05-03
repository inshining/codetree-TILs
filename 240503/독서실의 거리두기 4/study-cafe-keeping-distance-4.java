import java.util.*;
public class Main {
    public static int N;
    public static char[] line;
    public static int go(){
        int dis = 101;
        int[] arr = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++){
            if (line[i] == '1'){
                arr[cnt++] = i;
            }
        }

        for (int i = 1; i < cnt; i++){
            dis = Math.min(dis, arr[i] - arr[i-1]);
        }
        return dis;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        line = sc.next().toCharArray();
        int ans = -1;
        for (int i = 0; i < N; i++){
            for (int j =i+1; j <N; j++){
                if (line[i] == '0' && line[j] == '0'){
                    line[i] = '1';
                    line[j] = '1';
                    ans = Math.max(ans, go());
                    line[i] = '0';
                    line[j] = '0';
                }
            }
        }
        System.out.println(ans);
    }
}