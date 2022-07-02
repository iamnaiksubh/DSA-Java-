import java.util.Scanner;

public class IntersectionOfPoint {
    public static Node intersectionPoint(Node h1, Node h2){
        if(h1 == null || h2 == null)
            return null;
        Node t1 = h1;
        Node t2 = h2;

        while(t1 != t2){
            t1 = (t1 == null ? h2 : t1.next);
            t2 = (t2 == null ? h1 : t2.next);
        }

        return t1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int list1[] = new int[n];

        for(int i=0;i<n;i++)
            list1[i] = sc.nextInt();

        int m = sc.nextInt();
        int list2[] = new int[m];

        for(int i=0;i<m;i++)
            list2[i] = sc.nextInt();

        Node head1 = null, head2 = null;

        head1 = new Node(list1[0]);
        head2 = new Node(list2[0]);

        Node t1 = head1,t2 = head2;
        Node intersectionNode = null;
        for(int i=1;i<n;i++){
            Node nn = new Node(list1[i]);
            if(i == 2){
                intersectionNode = nn;
            }
            t1.next = nn;
            t1 = t1.next;
        }

        for(int i=1;i<m;i++){
            Node nn = new Node(list2[i]);
            t2.next = nn;
            t2 = t2.next;
        }

        t2.next = intersectionNode;

        Node node = intersectionPoint(head1,head2);

        System.out.println("Value of intersection node: " + node.data);
    }
}
