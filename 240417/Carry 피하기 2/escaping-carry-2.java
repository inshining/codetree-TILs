import java.util.*;
public class Main {
    public static int n;
    public static int[][] arr = new int[21][5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String temp;
        int start;
        for (int i =0; i < n; i++){
            temp = sc.next();
            start = 5-temp.length();
            for (int j = start; j < 5; j++){
                arr[i][j] = Character.getNumericValue(temp.charAt(j-start));
            }
        }
        
        int ans = -1;
        int digit;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k= j+1; k < n; k++){
                    int num = 0;
                    for (int idx = 0; idx < 5; idx++){
                        digit = arr[i][idx] + arr[j][idx] + arr[k][idx];
                        if ( digit>= 10){
                            break;
                        }
                        num = num * 10 + digit;

                        if (idx == 4){
                            ans = Math.max(ans, num);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}