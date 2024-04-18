import java.util.*;
public class Main {
    public static int N;
    public static int[] pos = new int[101];
    public static char[] alphabets = new char[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int num;
        char ch;
        for (int i = 0; i < N; i++){
            num = sc.nextInt();
            ch = sc.next().charAt(0);
            pos[i] = num;
            alphabets[num] = ch;
        }

        Arrays.sort(pos, 0, N);
        int ans = 0;
        int g,h;
        for (int i = 0; i < N; i++){
            g =0;
            h = 0;
            if (alphabets[pos[i]] == 'G') g++;
            else h++;

            for (int j =i+1; j <N; j++){
                if (alphabets[pos[j]] == 'G') g++;
                else h++;
                if (g == h){
                    ans = Math.max(ans, pos[j] - pos[i]);
                }
            }
        }
        System.out.println(ans);
    }
}