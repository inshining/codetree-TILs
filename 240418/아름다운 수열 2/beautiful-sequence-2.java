import java.util.*;
public class Main {
    public static int N, M;
    public static int[] arr1 = new int[100];
    public static int[] arr2 = new int[100];
    public static int[] temp = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            arr2[i] = sc.nextInt();

        Arrays.sort(arr2, 0, M);

        int ans = 0;
        for (int i = 0; i <= N -M; i++){
            for(int j =0; j < M; j++){
                temp[j] = arr1[j+i];
            }
            Arrays.sort(temp, 0, M);

            boolean isSame = true;
            for (int j = 0; j < M; j++){
                if (arr2[j] != temp[j]){
                    isSame = false;
                    break;
                }
            }
            if (isSame) ans++;
        }

        System.out.println(ans);
    }
}