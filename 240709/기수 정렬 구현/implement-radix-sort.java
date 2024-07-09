import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 6; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            arr.add(temp);
        }
        for (int i = 0; i < N; i++){
            int num = sc.nextInt();
            arr.get((int) Math.log10(num)).add(num);
        }
        // for (int i = 0; i < 6; i++){
        //     for (int j = 0; j < arr.get(i).size(); j++){
        //         System.out.println(arr.get(i).get(j));
        //     }
        // }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            ArrayList<Integer> temp = go(arr.get(i),i+1);
            for (int j = 0; j < temp.size(); j++){
                ans.add(temp.get(j));
            }
        }
        for (int i=0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
    public static ArrayList<Integer> go(ArrayList<Integer> arr, int k){
        for (int pos = 0; pos < k; pos++){
            ArrayList<ArrayList<Integer>> arr_new = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 10; i++){
                arr_new.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < arr.size(); i++){
                int t = arr.get(i) % ((pos + 1) * 10);
                arr_new.get(t).add(arr.get(i));
            }

            ArrayList<Integer> stored_arr = new ArrayList<>();
            for (int i = 0 ; i < 10; i++){
                for (int j = 0; j < arr_new.get(i).size(); j++){
                    stored_arr.add((int)arr_new.get(i).get(j));
                }
            }
            arr = stored_arr;
        }
        return arr;
    }
}