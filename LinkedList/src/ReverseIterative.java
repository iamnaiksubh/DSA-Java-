// Reverse a linkedlist iterative method

//class Node{
//    int data;
//    Node next;
//
//    Node(int data){
//        this.data = data;
//        next = null;
//    }
//}

public class ReverseIterative {
    static Node reverse(Node head){
        if(head == null || head.next == null)
            return head;

        Node prev = null, curr = head, nxt;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    static void print(Node head){

        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node t = head;

        t.next = new Node(2);
        t = t.next;
        t.next = new Node(3);
        t = t.next;
        t.next = new Node(4);

        print(head);
        head = reverse(head);
        print(head);
    }
}
