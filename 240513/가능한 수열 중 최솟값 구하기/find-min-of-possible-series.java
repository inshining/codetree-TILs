import java.util.*;

public class Main {
    public static int N;
    public static int[] board;
    public static boolean com = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        go(0);
        for (int i = 0; i < N; i++){
            System.out.print(board[i]);
        }
    }

    public static void go(int idx){
        if (idx >= N){
            com = true;
            return;
        }

        for (int i = 4; i < 7; i++){
            if (com){
                return;
            }
            board[idx] = i;
            if (isCheck(idx)){
                // System.out.println(idx + " " + board[idx]);
                go(idx+1);
            }
        }
    }
    public static boolean isCheck(int idx){
        for (int i = 1; i < N; i++){
            int right = idx - i + 1;
            int left = right - i;
            if (left < 0){
                break;
            }

            int num = 0;
            for (int j = 0; j < i; j++){
                if (board[left+j] == board[right+j]){
                    num++;
                }
            }
            if (num == i){
                return false;
            }
        }
        return true;
    }
}