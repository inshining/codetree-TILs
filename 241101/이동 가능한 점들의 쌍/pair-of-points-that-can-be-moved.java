import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[][] isRed = new boolean[N+1][N+1];

        int[][] board = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(board[i], 1000005);
            board[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[s][e] = w;
            if(s <= P || e <= P) isRed[s][e] = true;
        }


        for(int p = 1; p <= N; p++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    board[i][j] = Math.min(board[i][j], board[i][p] + board[p][j]);
                }
            }
        }
        for(int p = 1; p <= P; p++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    board[i][j] = Math.min(board[i][j], board[i][p] + board[p][j]);
                }
            }
        }


        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(board[s][e] <= 1000000 ){
                cnt++;
                ans += board[s][e];
            }
        }
        // System.out.println(isRed[1][2]);

        System.out.println(cnt);
        System.out.println(ans);
    }
}