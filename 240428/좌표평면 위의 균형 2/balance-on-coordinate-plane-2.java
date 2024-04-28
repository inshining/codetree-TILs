import java.util.*;
public class Main {
    public static int N;
    public static int[] X = new int[101];
    public static int[] Y = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++){
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;


        for (int i = 0; i < 101; i+= 2){
            for (int j = 0; j <101; j+= 2){
                int[] temp = new int[4];

                for (int k = 0; k < N; k++){
                    if (i < X[k] && j < Y[k]){
                        temp[0]++;
                    } else if( i > X[k] && j < Y[k]){
                        temp[1]++;
                    } else if( i > X[k] && j > Y[k]){
                        temp[2]++;
                    } else if( i < X[k] && j > Y[k]){
                        temp[3]++;
                    }
                }

                Arrays.sort(temp);

                ans = Math.min(ans, temp[temp.length - 1]);
            }
        }
        System.out.println(ans);
    }
}