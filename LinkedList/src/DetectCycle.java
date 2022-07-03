//

import java.util.*;
import java.io.*;

public class DetectCycle {
    static Node detectCycle(Node head){
        if(head == null || head.next == null)
            return head;

        Node slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                Node p = head;

                while(p != slow){
                    p = p.next;
                    slow = slow.next;
                }

                return p;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ar[] = new int[n];

        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        Node head = new Node(ar[0]);
        Node temp = head;
        Node cycleStart = null;

        for(int i=1;i<n;i++){
            Node nn = new Node(ar[i]);
            if(i == 3)
                cycleStart = nn;
            temp.next = nn;
            temp = temp.next;
        }

        temp.next = cycleStart;
        head = detectCycle(head);
        System.out.print(head.data);
    }
}
