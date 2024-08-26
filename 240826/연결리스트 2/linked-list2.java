import java.util.*;

class Node{
    int v;
    Node pre, next;

    public Node(int v){
        this.v = v;
        this.pre = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[] nodes = new Node[n+1];

        for (int i = 0; i <= n; i++){
            Node newNode = new Node(i);
            nodes[i] = newNode;
        }

        int q = sc.nextInt();
        for (int aa = 0; aa < q; aa++){
            int a = sc.nextInt();
            int i = sc.nextInt();

        if (a == 1){
            Node node = nodes[i];
            
            if (node.pre != null){
                node.pre.next = node.next;
            } 
            if (node.next != null){
                node.next.pre = node.pre;
            }
            node.next = node.pre = null;
        } else if (a == 2){
            int j = sc.nextInt();
            Node inode = nodes[i];
            Node jnode = nodes[j];

            if (jnode.pre != null){
                jnode.pre.next = jnode.next;
            }
            if (jnode.next != null){
                jnode.next.pre = jnode.pre;
            }

            if (inode.pre != null){
                inode.pre.next = jnode;
            }
            jnode.pre = inode.pre;
            jnode.next = inode;
            inode.pre = jnode;
        } else if(a==3){
            int j = sc.nextInt();
            Node inode = nodes[i];
            Node jnode = nodes[j];

            if (jnode.pre != null){
                jnode.pre.next = jnode.next;
            }
            if (jnode.next != null){
                jnode.next.pre = jnode.pre;
            }       

            if (inode.next != null){
                inode.next.pre = jnode;
            }   
            jnode.pre = inode;
            jnode.next = inode.next;
            inode.next = jnode;

        } else if(a == 4){
            Node node = nodes[i];
            StringBuilder sb = new StringBuilder();
            
            if(node.pre != null){
                sb.append(node.pre.v);
            } else
                sb.append(0);
            sb.append(" ");

            if (node.next != null){
                sb.append(node.next.v);
            } else{
                sb.append(0);
            }
            System.out.println(sb.toString());
        }
        }

        for (int i = 1; i <= n; i++){
            if (nodes[i].next != null){
                System.out.print(nodes[i].next.v + " ");

            } else{
                System.out.print(0 + " ");

            }
        }
        
    }
}