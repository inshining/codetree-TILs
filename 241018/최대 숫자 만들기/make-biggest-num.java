import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String A = a + b;
                String B = b + a;
                for(int i = 0; i < A.length(); i++){
                    if(A.charAt(i) > B.charAt(i)) return -1;
                    else if(A.charAt(i) < B.charAt(i)) return 1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(arr[i]);
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(sb.toString());

        // for(int = )
    }
}