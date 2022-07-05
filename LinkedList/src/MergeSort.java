import java.util.Scanner;

public class MergeSort {
    static Node findmid(Node h){
        if(h == null || h.next == null)
            return h;

        Node slow = h, fast = h;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node merge(Node h1, Node h2){

        Node nh = new Node(0);
        Node temp = nh;

        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                nh.next = h1;
                h1 = h1.next;
            }
            else{
                nh.next = h2;
                h2 = h2.next;
            }
            nh = nh.next;
        }

        if(h1 != null)
            nh.next = h1;
        if(h2 != null)
            nh.next = h2;

        return temp.next;
    }

    public static Node mergeSort(Node head) {
        //Your code goes here
        if (head == null || head.next == null)
            return head;

        Node mid = findmid(head);
        Node sh = mid.next;
        mid.next = null;

        return merge(mergeSort(head), mergeSort(sh));
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

        head = mergeSort(head);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
