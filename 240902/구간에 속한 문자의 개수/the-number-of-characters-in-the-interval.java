import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int k = sc.nextInt();

        int[][] s1 = new int[n+1][m+1];
        int[][] s2 = new int[n+1][m+1];
        int[][] s3 = new int[n+1][m+1];

        for (int i = 0; i < n; i++){
            String ab = sc.next();
            for (int j = 0; j < m; j++){
                char a = ab.charAt(j);
                int v1 = 0,  v2 = 0, v3 = 0;
                if (a == 'a'){
                    v1 = 1;
                } else if(a == 'b'){
                    v2 = 1;
                } else if(a == 'c'){
                    v3 = 1;
                }

                s1[i+1][j+1] += s1[i+1][j] + s1[i][j+1] - s1[i][j] + v1;
                s2[i+1][j+1] += s2[i+1][j] + s2[i][j+1] - s2[i][j] + v2;
                s3[i+1][j+1] += s3[i+1][j] + s3[i][j+1] - s3[i][j] + v3;

            }
        }

        for (int i = 0; i < k; i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            int v1 = s1[r2][c2] - s1[r2][c1-1] - s1[r1-1][c2] + s1[r1-1][c1-1];
            int v2 = s2[r2][c2] - s2[r2][c1-1] - s2[r1-1][c2] + s2[r1-1][c1-1];
            int v3 = s3[r2][c2] - s3[r2][c1-1] - s3[r1-1][c2] + s3[r1-1][c1-1];

            System.out.println(v1 + " " + v2 + " " + v3);
        }


    }
}