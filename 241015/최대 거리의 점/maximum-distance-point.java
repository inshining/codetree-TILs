import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        for(int i= 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int low = 0;
        int high = arr[N-1];
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            // System.out.println(low + " " + high + " " + mid);
            if(cal(arr, mid, M)){
                ans = Math.max(ans, mid);
                low = mid + 1;
            }else high = mid -1;
        }
        System.out.println(ans);
    }

    static boolean cal(int[] arr, int mid, int m){
        int num = 1;
        int last = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - last >= mid){
                num++;
                last = arr[i];
            }
        }
        if(num >= m){
            return true;
        }
        return false;
    }
}