import java.util.Scanner;

public class Distinct {
    static Node distinct(Node h){
        if(h == null || h.next == null)
            return h;
        Node nh = h;
        while(h.next != null){
            if(h.data == h.next.data)
                h.next = h.next.next;
            else
                h = h.next;
        }
        return nh;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];

        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        Node head = new Node(ar[0]);
        Node temp = head;
        for(int i=1;i<n;i++){
            temp.next = new Node(ar[i]);
            temp = temp.next;
        }

        head = distinct(head);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
