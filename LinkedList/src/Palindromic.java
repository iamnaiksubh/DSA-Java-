// LinkedList is Palindrome or not
import java.util.*;
import java.io.*;
public class Palindromic {

    static Node middle(Node head){
        if(head == null || head.next == null)
            return head;
        Node slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

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
    static Boolean isPalindrome(Node head){
        if(head == null || head.next == null)
            return true;

        Node temp = middle(head);
        Node mid = temp.next;
        temp.next = null;
        mid = reverse(mid);

        while(head != null && mid != null){
            if(head.data != mid.data)
                return false;
            head = head.next;
            mid = mid.next;
        }

        return true;
    }
    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];

        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        head = new Node(ar[0]);
        Node temp = head;
        for(int i=1;i<n;i++){
            Node nn = new Node(ar[i]);
            temp.next = nn;
            temp = temp.next;
        }

        if(isPalindrome(head))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

    }
}
