import java.util.*;

class Node{
    String v;
    Node pre, next;

    public Node(String v){
        this.v = v;
        this.pre = this.next = null;
    }

}

public class Main {
    public static Node cur;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String v = sc.next();

        cur = new Node(v);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            if (a == 1){
                String b = sc.next();
                insert(b, a);
            } else if(a==2){
                String b = sc.next();
                insert(b, a);

            } else if(a==3){
                if (cur.pre != null){
                    cur = cur.pre;
                }
            } else if(a==4){
                if (cur.next != null){
                    cur = cur.next;
                }
            }


            print();
        }

    }

    public static void insert(String v, int pos){
        Node n = new Node(v);
        if (pos == 1){
            if (null != cur.pre){
                cur.pre.next = n;
                n.pre = cur.pre;
            }
            cur.pre = n;
            n.next = cur;
        } else if(pos == 2){
            if (null != cur.next){
                cur.next.pre = n;
                n.next = cur.next;
            }
            cur.next = n;
            n.pre = cur;
        }
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();
        
        if (cur.pre != null)
            sb.append(cur.pre.v);
        else
            sb.append("(Null)");
        sb.append(" ");

        if (cur != null)
            sb.append(cur.v);
        else
            sb.append("(Null)");
        sb.append(" ");

        if (cur.next != null)
            sb.append(cur.next.v);
        else
            sb.append("(Null)");
        System.out.println(sb.toString());
    }
}