import java.util.*;
public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> nums = new TreeSet<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            nums.add(k);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int idx = 1;
        for (int num : nums){
            hm.put(num, idx);
            idx++;
        }

        for (int i = 0 ; i < q; i++){
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();

            int f = nums.floor(a1);
            int c = nums.ceiling(b1);
            int a2 = hm.get(f);
            int b2 = hm.get(c);

            System.out.println(b2 - a2 + 1);
        }
    }
}