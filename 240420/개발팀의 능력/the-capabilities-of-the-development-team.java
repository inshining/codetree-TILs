import java.util.*;
public class Main {
    public static int[] arr = new int[5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++){
            for (int j=i+1; j <5; j++){
                for (int r=0; r <5; r++){
                    for (int c=r+1; c<5; c++){
                        if (i == r || i==c|| j==r||j==c) continue;
                        int A = arr[i] + arr[j];
                        int B = arr[r] + arr[c];
                        int C = total - A - B;

                        if (A == B || A == C || B == C) continue;
                        
                        int temp = Math.max(Math.abs(A-B), Math.abs(B-C));
                        temp = Math.max(Math.abs(A-C), temp);
                        ans = Math.min(ans, temp);


                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }
}