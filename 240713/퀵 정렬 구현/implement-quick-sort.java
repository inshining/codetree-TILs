import java.util.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, arr.length - 1);

        for (int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void sort(int[] arr, int start, int end){
        if (start < end){
            int pIdx = partition(arr, start, end);
            sort(arr, start, pIdx -1);
            sort(arr, pIdx +1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pIdx = start;

        for (int i = start; i < end; i++){
            if (arr[i] <= pivot){
                swap(arr, pIdx, i);
                pIdx++;
            }
        }
        swap(arr, pIdx, end);
        return pIdx;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }
}