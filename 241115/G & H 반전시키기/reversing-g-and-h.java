import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String output = sc.nextLine();

        int right = 1;
        int wrong = 0;
        for(int i = 0; i < n; ){
            if(input.charAt(i) == output.charAt(i)) {
                while (i < n && input.charAt(i) == output.charAt(i)) {
                    i++;
                }
                right++;
            } else{
                while (i < n && input.charAt(i) != output.charAt(i)) {
                    i++;
                }
                wrong++;
            }
        }
        int ans = Math.min(right, wrong);
        System.out.println(ans);
    }
}