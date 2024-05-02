import java.util.*;
public class Main {
    public static int[] arr = new int[15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 15; i++){
            arr[i] = sc.nextInt();
        }

        for (int a = 1; a <= 40; a++){
            for (int b = a; b <= 40; b++){
                for (int c = b; c <=40; c++){
                    for (int d=c; d <= 40; d++){
                        int[] arr2 = new int[]{
                            a,b,c,d,a+b, b+c, c+d, d+a, a+c, b+d,
                            a+b+c, a+b+d, a+c+d, b+c+d, a+b+c+d
                        };
                        Arrays.sort(arr);
                        Arrays.sort(arr2);

                        boolean isSame = true;
                        for (int i =0; i < 15; i++){
                            if(arr[i] != arr2[i]){
                                isSame=false;
                            }
                        }
                        if(isSame){
                            System.out.print(a + " " + b + " " + c + " " +d);
                        }
                    }
                }
            }
        }
    }
}