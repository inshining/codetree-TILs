import java.util.*;

public class Main {
    public static int n, m, r, c;
    public static int[][] board;
    public static char[] arr;
    public static HashMap<String, Integer> dice = new HashMap<>();
    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        r--;
        c--;
        board = new int[n][n];
        board[r][c] = 6;
        arr = new char[m];
        for (int i =0 ; i < m; i++){
            arr[i] = sc.next().charAt(0);
        }

        dice.put("up", 1);
        dice.put("right", 3);
        dice.put("front", 2);

        for (int i = 0; i < m; i++){
            go(arr[i]);
        }

        // for (int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(board[i]));
        // }

        int ans = Arrays.stream(board).flatMapToInt(Arrays::stream).sum();
        System.out.println(ans);
    }

    public static void diceLeft(){
        int left = dice.get("up");
        int right = dice.get("right");
        dice.put("right", Math.abs(7-left));
        dice.put("up", right);
    }
    
    public static void diceRight(){
        int up = dice.get("up");
        int right = dice.get("right"); 
        dice.put("right", up);
        dice.put("up", Math.abs(7-right));
    }

    public static void diceUp(){
        int up = dice.get("up");
        int front = dice.get("front"); 
        dice.put("front", Math.abs(7-up));
        dice.put("up", front);
    }

    public static void diceDown(){
        int up = dice.get("up");
        int front = dice.get("front"); 
        dice.put("up", Math.abs(7-front));
        dice.put("front", up);      
    }

    public static void go(char ch){
        HashMap<Character, Integer> dir = new HashMap<Character, Integer>(){{
            put('U', 0);
            put('R', 1);
            put('D', 2);
            put('L', 3);
        }};

        int d = dir.get(ch);
        int ny = r + dy[d];
        int nx = c + dx[d];

        if (ny < 0 || n <= ny || nx < 0 || n <= nx){
            return;
        }

        r = ny;
        c = nx;

        if (d == 0){
            diceUp();
        } else if(d==1){
            diceRight();
        } else if(d==2){
            diceDown();
        } else if(d==3){
            diceLeft();
        }

        board[r][c] = Math.abs(7- dice.get("up"));

    }
}