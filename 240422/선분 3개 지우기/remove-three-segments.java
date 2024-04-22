import java.util.*;
public class Main {
    public static int N;
    public static int[] A = new int[11];
    public static int[] B = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < N; i++){
            for (int j = i+1; j <N; j++){
                for (int k=j+1; k<N; k++){
                    int[] line = new int[101];
                    for (int idx = 0; idx < N; idx++){
                        if (idx == i || idx==j || idx==k) continue;
                        for (int pos =A[idx]; pos < B[idx]+1; pos++){
                            line[pos] += 1;
                        }
                    }
                    boolean isSucced = true;
                    for (int p = 0; p <101; p++){
                        if (line[p] >1) {
                            isSucced = false;
                            break;
                        }
                            
                    }

                    if (isSucced){
                        ans++;
                    } 
                }
            }
        }
        System.out.println(ans);
    }
}