import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] arr = new Long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        
        Arrays.sort(arr, new Comparator<Long>(){
            @Override
            public int compare(Long a, Long b){
                int aSize = (int)(Math.log10(a) + 1);
                int bSize = (int)(Math.log10(b) + 1);
                long A = (long) (Math.pow(10, aSize) * b );
                A += a;
                long B = (long) ( Math.pow(10, bSize) * a );
                B += b;
                if( A > B){
                    return 1;
                } else if(A < B){
                    return -1;
                }
                return 0;
            }
        });
        long ans = arr[0];
        for(int i = 1; i < n; i++){
            int size = (int)(Math.log10(arr[i]) + 1);
            ans *= (long) (Math.pow(10, size));
            ans += arr[i];
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(ans);

        // for(int = )
    }
}