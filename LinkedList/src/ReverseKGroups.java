// Reverse the LinkedList in group of k nodes.
import java.util.Scanner;

public class ReverseKGroups {

    static Node reverseKGroups(Node head, int k){
        if(head == null || head.next == null)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy, curr = dummy, nxt = dummy;

        int countLen = 0;

        while(curr.next != null){
            curr = curr.next;
            countLen++;
        }

        while(countLen >= k){
            curr = prev.next;
            nxt = curr.next;

            for(int i=1;i<k;i++){
                curr.next = nxt.next;
                nxt.next =  prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }

            prev = curr;
            countLen -= k;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];

        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        int k = sc.nextInt();

        head = new Node(ar[0]);
        Node temp = head;
        for(int i=1;i<n;i++){
            Node nn = new Node(ar[i]);
            temp.next = nn;
            temp = temp.next;
        }

        head = reverseKGroups(head,k);

        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");

    }
}
