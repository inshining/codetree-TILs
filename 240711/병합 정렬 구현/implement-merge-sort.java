import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        mergesort(arr);
        for (int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
        // System.out.println(arr);
    }

    public static void mergesort(int[] arr){
        int size = arr.length;
        if (size < 2) return;
        int mid = size / 2;
        int left[] = new int[mid];
        int right[] = new int[size-mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < size; i++){
            right[i-mid] = arr[i];
        }
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);
    }

    public static void merge(int arr[], int left[], int right[]){
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR){
            if (left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            } else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}