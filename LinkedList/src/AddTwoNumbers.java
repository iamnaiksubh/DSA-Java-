// Two Reverse LinkedList are give return head of the new linkedlist i.e addition of the two linked list

import java.io.*;
import java.util.*;


public class AddTwoNumbers {
    public static Node addTwoNumber(Node h1,Node h2){
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        Node dummy = new Node(-1);
        Node t = dummy;
        int sum,carry=0;
        while(h1 != null || h2 != null){
            sum = 0;
            if(h1 != null) {
                sum = h1.data;
                h1 = h1.next;
            }

            if(h2 != null){
                sum += h2.data;
                h2 = h2.next;
            }

            sum += carry;
            Node nn = new Node(sum%10);
            t.next = nn;
            t = t.next;
            carry = sum/10;
        }

        if(carry > 0)
            t.next = new Node(carry);

        return dummy.next;
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

        for(int i=1;i<n;i++){
            Node nn = new Node(list1[i]);
            t1.next = nn;
            t1 = t1.next;
        }

        for(int i=1;i<m;i++){
            Node nn = new Node(list2[i]);
            t2.next = nn;
            t2 = t2.next;
        }

        Node newHead = addTwoNumber(head1,head2);

        while(newHead != null){
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }

    }
}
