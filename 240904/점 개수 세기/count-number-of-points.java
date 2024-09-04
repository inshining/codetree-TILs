import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); 
        int q = Integer.parseInt(st.nextToken()); 

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 정렬합니다.
        Arrays.sort(numbers);

        // 쿼리를 처리합니다.
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken());

            // lower bound와 upper bound를 사용하여 범위 내 숫자의 개수를 계산합니다.
            int lowerIdx = lowerBound(numbers, a);
            int upperIdx = upperBound(numbers, b);

            // upperIdx는 b보다 큰 첫 번째 인덱스를 가리키기 때문에, upperIdx - lowerIdx가 범위 내 숫자의 개수입니다.
            System.out.println(upperIdx - lowerIdx);
        }
    }

    // lower bound: 배열에서 target 이상의 첫 번째 인덱스를 찾는 함수
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // upper bound: 배열에서 target보다 큰 첫 번째 인덱스를 찾는 함수
    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}