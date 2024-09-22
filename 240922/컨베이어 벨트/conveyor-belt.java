import java.util.*;

public class Main {
    public static int[] d;
    public static int n, t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();

        d = new int[2 * n];
        // int[] down = new int[n];

        for (int i = 0; i < n *2; i++){
            d[i] = sc.nextInt();
        }

        for (int i =0; i < t; i++){
            go();
        }

        for (int i = 0; i < n; i++){
            System.out.print(d[i] + " ");

        }
        System.out.println();
               for (int i = 0; i < n; i++){
            System.out.print(d[n + i] + " ");

        } 
    }

    public static void go(){
        int[] temp = new int[n*2];

        for (int i = 0; i < 2 * n - 1; i++){
            temp[i+1] = d[i];
        }
        temp[0] = d[2*n -1];

        for (int i = 0; i < 2* n; i++){
            d[i] = temp[i];
        }
    }

}