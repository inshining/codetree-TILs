import java.util.*;
public class Main {
    public static int N;
    public static int[] X = new int[21];
    public static int[] Y = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < 22; i++){
            for (int j = i+1; j < 22; j++){
                for (int k =j+1; k < 22; k++){
                    int[] temp = new int[N];

                    for (int idx = 0; idx < N; idx++){
                        if (i < 10){
                            if (i == X[idx]) temp[idx] = 1;
                        } else{
                            if (i - 11 == Y[idx]) temp[idx] =1;
                        }

                        if (j < 10){
                            if (j == X[idx]) temp[idx] = 1;
                        } else{
                            if (j - 11 == Y[idx]) temp[idx] =1;
                        }

                        if (k < 10){
                            if (k == X[idx]) temp[idx] = 1;
                        } else{
                            if (k - 11 == Y[idx]) temp[idx] =1;
                        }
                    }

                    boolean isSuccess = true;

                    for (int idx = 0; idx <N; idx++){
                        if (temp[idx] == 0){
                            isSuccess = false;
                            break;
                        }
                    }
                    if (isSuccess){
                        ans = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}